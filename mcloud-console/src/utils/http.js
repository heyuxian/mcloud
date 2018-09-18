import fetch from 'dva/fetch';
import { notification } from 'antd';
import { routerRedux } from 'dva/router';
import { stringify } from 'qs';
import store from '../index';
import { getAccessToken } from '../utils/authority';

const codeMessage = {
  200: '服务器成功返回请求的数据',
  201: '新建或修改数据成功。',
  202: '一个请求已经进入后台排队（异步任务）',
  204: '删除数据成功。',
  400: '发出的请求有错误，服务器没有进行新建或修改数据,的操作。',
  401: '用户没有权限（令牌、用户名、密码错误）。',
  403: '用户得到授权，但是访问是被禁止的。',
  404: '发出的请求针对的是不存在的记录，服务器没有进行操作',
  406: '请求的格式不可得。',
  410: '请求的资源被永久删除，且不会再得到的。',
  422: '当创建一个对象时，发生一个验证错误。',
  500: '服务器发生错误，请检查服务器',
  502: '网关错误',
  503: '服务不可用，服务器暂时过载或维护',
  504: '网关超时',
};
const Headers = {
  AUTH_TOKEN: 'x-auth-token',
  PAGE_TOTAL: 'x-page-total',
  PAGE_CURRENT: 'x-page-current',
  PAGE_SIZE: 'x-page-size',
};

function checkStatus(response) {
  if (response.status >= 200 && response.status < 300) {
    return response;
  }
  const errorText = codeMessage[response.status] || response.statusText;
  const error = new Error(errorText);
  error.name = response.status;
  throw error;
}

export async function httpGet(url, params) {
  const options = {
    method: 'get',
  };
  let urlOfParams = url;
  if (params) {
    urlOfParams = `${url}?${stringify(params)}`;
  }
  return request(urlOfParams, options);
}

export async function httpPost(url, params) {
  const options = {
    method: 'post',
    body: JSON.stringify(params),
  };
  return request(url, options);
}

export async function httpPut(url, params) {
  const options = {
    method: 'put',
    body: JSON.stringify(params),
  };
  return request(url, options);
}

export async function httpDelete(url, params = {}) {
  const options = {
    method: 'delete',
    body: JSON.stringify(params),
  };
  return request(url, options);
}

export async function request(url, params) {
  const options = { ...params };
  options.headers = {
    Accept: 'application/json',
    'Content-Type': 'application/json; charset=utf-8',
    ...options.headers,
  };
  if (getAccessToken()) {
    options.headers.Authorization = getAccessToken();
  }
  const response = await fetch(url, options);
  try {
    checkStatus(response);
  } catch (e) {
    return handleError(e, url);
  }
  if (response.status === 204) {
    return;
  }
  const data = await response.json();
  const { headers } = response;
  if (url === '/api/v1/auth/login') {
    return {
      status: 'ok',
      type: 'account',
      authority: { ...data },
    };
  }
  if (
    headers.get(Headers.PAGE_TOTAL) &&
    headers.get(Headers.PAGE_CURRENT) &&
    headers.get(Headers.PAGE_SIZE)
  ) {
    return {
      pagination: {
        current: parseInt(headers.get(Headers.PAGE_CURRENT), 1),
        pageSize: parseInt(headers.get(Headers.PAGE_SIZE), 10),
        total: parseInt(headers.get(Headers.PAGE_TOTAL), 0),
      },
      sort: options.sort,
      data,
    };
  }
  return data;
}

function handleError(e, url) {
  if (url === '/api/v1/auth/login' && e.name === 401) {
    return {
      status: 'error',
      type: 'account',
    };
  }
  const { dispatch } = store;
  if (e.name === 401) {
    dispatch({
      type: 'login/logout',
    });
    return;
  }
  notification.error({
    message: `请求错误 ${e.name}: ${url}`,
    description: e.message,
  });
  if (e.name === 403) {
    dispatch(routerRedux.push('/auth/login'));
    return;
  }
  if (e.name <= 504 && e.name >= 500) {
    dispatch(routerRedux.push('/exception/500'));
    return;
  }
  if (e.name >= 404 && e.name < 422) {
    dispatch(routerRedux.push('/exception/404'));
  }
}
