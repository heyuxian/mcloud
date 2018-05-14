import moment from 'moment';
import { queryAppInfo, queryMetics } from '../services/api';

export default {
  namespace: 'details',
  state: {
    build: {},
    memory: {},
  },

  effects: {
    *fetchAppInfo({ payload }, { call, put }) {
      const response = yield call(queryAppInfo, payload.instanceId);
      yield put({
        type: 'saveAppInfo',
        payload: response.build,
      });
    },
    *fetchMetrics({ payload }, { call, put }) {
      const response = yield call(queryMetics, payload);
      const memory = [
        {
          max: response.measurements[0].value,
          time: moment.now().valueOf(),
          name: 'MAX',
        },
      ];
      yield put({
        type: 'saveMetrics',
        payload: memory,
      });
    },
  },

  reducers: {
    saveAppInfo(state, action) {
      return {
        ...state,
        build: action.payload,
      };
    },
    saveMetrics(state, action) {
      return {
        ...state,
        memory: action.payload,
      };
    },
  },
};
