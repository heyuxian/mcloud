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
    *fetchMemory({ payload }, { call, put }) {
      const heapMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: 'jvm.memory.max',
        tags: {
          area: 'heap',
        },
      });
      const heapUsed = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: 'jvm.memory.used',
        tags: {
          area: 'heap',
        },
      });
      const nonheapMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: 'jvm.memory.max',
        tags: {
          area: 'nonheap',
        },
      });
      const nonheapUsed = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: 'jvm.memory.used',
        tags: {
          area: 'nonheap',
        },
      });
      const nonheapMetaspace = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: 'jvm.memory.used',
        tags: {
          area: 'nonheap',
          id: 'Metaspace',
        },
      });
      const memory = {
        heap: {
          max: heapMax.measurements[0].value,
          used: heapUsed.measurements[0].value,
        },
        nonheap: {
          max: nonheapMax.measurements[0].value,
          used: nonheapUsed.measurements[0].value,
          metaspace: nonheapMetaspace.measurements[0].value,
        },
      };
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
      /* let memory = [...state.memory, ...action.payload];
      if (memory.length > 10) {
        memory = memory.slice(memory.length - 20, memory.length);
      } */
      return {
        ...state,
        memory: action.payload,
      };
    },
  },
};
