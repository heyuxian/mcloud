import { queryApps } from '../services/dashboard';

export default {
  namespace: 'monitoring',

  state: {
    apps: [],
  },

  effects: {
    *fetchApps(_, { call, put }) {
      const response = yield call(queryApps);
      yield put({
        type: 'saveApps',
        payload: response,
      });
    },
  },

  reducers: {
    saveApps(state, action) {
      return {
        ...state,
        apps: action.payload,
      };
    },
  },
};
