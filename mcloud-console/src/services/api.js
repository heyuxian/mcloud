import { stringify } from 'qs';
import lodash from 'lodash';
import request from '../utils/request';
import { httpPost, httpGet } from '../utils/http';

export async function queryProjectNotice() {
  return request('/api/project/notice');
}

export async function queryActivities() {
  return request('/api/activities');
}

export async function queryRule(params) {
  return request(`/api/rule?${stringify(params)}`);
}

export async function removeRule(params) {
  return request('/api/rule', {
    method: 'POST',
    body: {
      ...params,
      method: 'delete',
    },
  });
}

export async function addRule(params) {
  return request('/api/rule', {
    method: 'POST',
    body: {
      ...params,
      method: 'post',
    },
  });
}

export async function fakeSubmitForm(params) {
  return request('/api/forms', {
    method: 'POST',
    body: params,
  });
}

export async function fakeChartData() {
  return request('/api/fake_chart_data');
}

export async function queryTags() {
  return request('/api/tags');
}

export async function queryBasicProfile() {
  return request('/api/profile/basic');
}

export async function queryAdvancedProfile() {
  return request('/api/profile/advanced');
}

export async function queryFakeList(params) {
  return request(`/api/fake_list?${stringify(params)}`);
}

export async function fakeRegister(params) {
  return request('/api/register', {
    method: 'POST',
    body: params,
  });
}
export async function queryNotices() {
  return request('/api/notices');
}

const API_PREFIX = '/api/v1';

export async function login(params) {
  return httpPost(`${API_PREFIX}/auth/login`, params);
}

export async function queryApps() {
  return httpGet(`${API_PREFIX}/registry/applications`);
}

export async function queryAppInfo(appId) {
  return httpGet(`${API_PREFIX}/registry/instances/${appId}/actuator/info`);
}

export async function queryMetics({ instanceId, metric, tags }) {
  const params = tags ? { tag: lodash.entries(tags).map(([name, value]) => `${name}:${value}`).join(',') } : {};
  return httpGet(
    `${API_PREFIX}/registry/instances/${instanceId}/actuator/metrics/${metric}`,
    params
  );
}
