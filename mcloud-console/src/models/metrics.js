import { queryMetrics } from '../services/api';

export default {
  namespace: 'metrics',
  state: {
    list: [],
    metricDetail: {},
    visible: false,
    metricValueType: 'string',
  },

  effects: {
    *fetchMetrics({ payload }, { call, put }) {
      const metrics = yield call(queryMetrics, {
        instanceId: payload.instanceId,
      });
      const data = metrics.names.map((name) => {
        return {
          name,
          availableTags: [],
        };
      });
      yield put({
        type: 'saveMetrics',
        payload: data,
      });
    },
    *fetchMetric({ payload }, { call, put }) {
      const metric = yield call(queryMetrics, {
        instanceId: payload.instanceId,
        metric: payload.metric,
      });
      yield put({
        type: 'saveMetric',
        payload: metric,
      });
    },
    *fetchMetricDetail({ payload }, { call, put }) {
      const metric = yield call(queryMetrics, {
        instanceId: payload.instanceId,
        metric: payload.metric,
        tags: payload.tags,
      });
      yield put({
        type: 'saveMetricDetail',
        payload: metric,
      });
    },
    *selectMetric({ payload }, { put }) {
      yield put({
        type: 'saveSelectedMetric',
        payload,
      });
    },
    *changeModalVisible({ payload }, { put }) {
      yield put({
        type: 'saveModalVisible',
        payload: payload.visible,
      });
    },
    *changeMetricValueType({ payload }, { put }) {
      yield put({
        type: 'saveMetricValueType',
        payload: payload.type,
      });
    },
  },
  reducers: {
    saveMetrics(state, action) {
      return {
        ...state,
        list: action.payload,
      };
    },
    saveMetric(state, action) {
      const metric = action.payload;
      const newList = state.list.map((item) => {
        if (item.name === metric.name) {
          return {
            name: metric.name,
            measurements: metric.measurements,
            availableTags: metric.availableTags.length !== 0 ? metric.availableTags : 'NO_AVAILABLE_TAGS',
          };
        }
        return item;
      });
      // 保存对应 metric 的 metrics
      return {
        ...state,
        list: newList,
      };
    },
    saveSelectedMetric(state, action) {
      const { metric, value } = action.payload;
      const newList = state.list.map((item) => {
        if (item.name === metric) {
          return {
            name: item.name,
            measurements: item.measurements,
            availableTags: item.availableTags,
            selectedTags: value,
          };
        }
        return item;
      });
      return {
        ...state,
        list: newList,
      };
    },
    saveMetricDetail(state, action) {
      return {
        ...state,
        metricDetail: action.payload,
        visible: true,
      };
    },
    saveModalVisible(state, action) {
      return {
        ...state,
        visible: action.payload,
      };
    },
    saveMetricValueType(state, action) {
      return {
        ...state,
        metricValueType: action.payload,
      };
    },
  },
};
