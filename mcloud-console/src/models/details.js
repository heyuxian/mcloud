import { queryAppInfo, queryMetics } from '../services/api';

export default {
  namespace: 'details',
  state: {
    build: {},
    memory: {
      max: {},
      used: {},
    },
  },

  effects: {
    *fetchAppInfo({ payload }, { call, put }) {
      const response = yield call(queryAppInfo, payload.instanceId);
      yield put({
        type: 'saveAppInfo',
        payload: response.build,
      });
    },
    *fetchMaxMemory({ payload }, { call, put }) {
      const MAX_MEMORY = 'jvm.memory.max';
      const heapMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'heap',
        },
      });
      const heapEdenSpace = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'heap',
          id: 'PS Eden Space',
        },
      });
      const heapSurvivorSpace = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'heap',
          id: 'PS Survivor Space',
        },
      });
      const heapOldGen = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'heap',
          id: 'PS Old Gen',
        },
      });
      const nonheapMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'nonheap',
        },
      });
      const nonheapMetaspaceMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'nonheap',
          id: 'Metaspace',
        },
      });
      const nonheapCompressedClassSpaceMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'nonheap',
          id: 'Compressed Class Space',
        },
      });
      const nonheapCodeCacheMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: MAX_MEMORY,
        tags: {
          area: 'nonheap',
          id: 'Code Cache',
        },
      });
      const memory = {
        heap: {
          value: heapMax.measurements[0].value,
          edenSpace: heapEdenSpace.measurements[0].value,
          survivorSpace: heapSurvivorSpace.measurements[0].value,
          oldGen: heapOldGen.measurements[0].value,
        },
        nonheap: {
          value: nonheapMax.measurements[0].value,
          metaspace: nonheapMetaspaceMax.measurements[0].value,
          compressedClassSpace: nonheapCompressedClassSpaceMax.measurements[0].value,
          codeCache: nonheapCodeCacheMax.measurements[0].value,
        },
      };
      yield put({
        type: 'saveMaxMemory',
        payload: memory,
      });
    },
    *fetchUsedMemory({ payload }, { call, put }) {
      const USED_MEMORY = 'jvm.memory.used';
      const heapMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'heap',
        },
      });
      const heapEdenSpace = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'heap',
          id: 'PS Eden Space',
        },
      });
      const heapSurvivorSpace = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'heap',
          id: 'PS Survivor Space',
        },
      });
      const heapOldGen = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'heap',
          id: 'PS Old Gen',
        },
      });
      const nonheapMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'nonheap',
        },
      });
      const nonheapMetaspaceMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'nonheap',
          id: 'Metaspace',
        },
      });
      const nonheapCompressedClassSpaceMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'nonheap',
          id: 'Compressed Class Space',
        },
      });
      const nonheapCodeCacheMax = yield call(queryMetics, {
        instanceId: payload.instanceId,
        metric: USED_MEMORY,
        tags: {
          area: 'nonheap',
          id: 'Code Cache',
        },
      });
      const memory = {
        heap: {
          value: heapMax.measurements[0].value,
          edenSpace: heapEdenSpace.measurements[0].value,
          survivorSpace: heapSurvivorSpace.measurements[0].value,
          oldGen: heapOldGen.measurements[0].value,
        },
        nonheap: {
          value: nonheapMax.measurements[0].value,
          metaspace: nonheapMetaspaceMax.measurements[0].value,
          compressedClassSpace: nonheapCompressedClassSpaceMax.measurements[0].value,
          codeCache: nonheapCodeCacheMax.measurements[0].value,
        },
      };
      yield put({
        type: 'saveUsedMemory',
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
    saveMaxMemory(state, action) {
      return {
        ...state,
        memory: {
          used: state.memory.used,
          max: action.payload,
        },
      };
    },
    saveUsedMemory(state, action) {
      return {
        ...state,
        memory: {
          max: state.memory.max,
          used: action.payload,
        },
      };
    },
  },
};
