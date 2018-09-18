import React from 'react';
import { Table, Card, Tag, Modal, TreeSelect, Button, Radio } from 'antd';
import { connect } from 'dva';
import moment from 'moment';
import prettyBytes from 'pretty-bytes';
import DescriptionList from 'components/DescriptionList';

const { TreeNode } = TreeSelect;
const { Description } = DescriptionList;
const RadioGroup = Radio.Group;

@connect(({ metrics, loading }) => ({
  metrics,
  loading: loading.models.metrics,
}))
export default class Details extends React.Component {
  componentDidMount() {
    const { instanceId } = this.props.match.params;
    this.fetchMetrics(instanceId);
  }
  onChange = (value, record) => {
    this.props.dispatch({
      type: 'metrics/selectMetric',
      payload: {
        metric: record.name,
        value,
      },
    });
  };
  fetchMetricDetail = (record) => {
    const tags = record.selectedTags ? record.selectedTags.map((value) => {
      const { tag } = record.availableTags.filter((item) => {
        return item.values.filter(val => val === value).length === 1;
      })[0];
      return {
        name: tag,
        value,
      };
    }) : [];
    const { instanceId } = this.props.match.params;
    this.props.dispatch({
      type: 'metrics/fetchMetricDetail',
      payload: {
        instanceId,
        metric: record.name,
        tags,
      },
    });
  };
  fetchMetric = (name) => {
    const { instanceId } = this.props.match.params;
    this.props.dispatch({
      type: 'metrics/fetchMetric',
      payload: {
        instanceId,
        metric: name,
      },
    });
  };
  fetchMetrics = (instanceId) => {
    this.props.dispatch({
      type: 'metrics/fetchMetrics',
      payload: {
        instanceId,
      },
    });
  };
  handleModalVisible = (visible) => {
    this.props.dispatch({
      type: 'metrics/changeModalVisible',
      payload: {
        visible,
      },
    });
  };
  handleMetricValueType = (e) => {
    this.props.dispatch({
      type: 'metrics/changeMetricValueType',
      payload: {
        type: e.target.value,
      },
    });
  };
  loadData = (data, record) => {
    if (!data || data.length === 0) {
      this.fetchMetric(record.name);
    }
  };
  renderTree = (data, record) => {
    return (
      <TreeSelect
        style={{ width: 300 }}
        value={record.selectedTags}
        dropdownStyle={{ maxHeight: 400, overflow: 'auto' }}
        placeholder="Please select"
        allowClear
        multiple
        treeDefaultExpandAll
        showCheckedStrategy={TreeSelect.SHOW_ALL}
        onChange={value => this.onChange(value, record)}
      >
        {
          data.map((item) => {
            return (
              <TreeNode value={item.tag} title={item.tag} key={item.tag}>
                {
                  item.values.map((value) => {
                    return (
                      <TreeNode value={value} title={value} key={value} />
                    );
                  })
                }
              </TreeNode>
            );
          })
        }
      </TreeSelect>
    );
  };
  render() {
    const columns = [{
      title: 'Name',
      dataIndex: 'name',
      render: (data) => {
        return <Tag>{data}</Tag>;
      },
    }, {
      title: 'Available Tags',
      dataIndex: 'availableTags',
      render: (data, record) => {
        if (record.availableTags === 'NO_AVAILABLE_TAGS') {
          return <span>No Available Tags</span>;
        }
        if (!data || data.length === 0) {
          return <Button onClick={() => this.loadData(data, record)}>Load</Button>;
        }
        return this.renderTree(data, record);
      },
    }, {
      title: 'Fetch Metric Detail',
      render: (data, record) => {
        if ((record.selectedTags && record.selectedTags.length !== 0)
        || record.availableTags === 'NO_AVAILABLE_TAGS') {
          return (
            <Button
              onClick={() => this.fetchMetricDetail(record)}
            >Call
            </Button>
          );
        }
      },
    }];
    const { metrics: { list, visible, metricDetail, metricValueType } } = this.props;
    return (
      <Card>
        <Table columns={columns} rowKey="name" dataSource={list} />
        {
          metricDetail && metricDetail.name ? (
            <Modal
              title="Metric Detail"
              visible={visible}
              onOk={() => this.handleModalVisible(false)}
              onCancel={() => this.handleModalVisible(false)}
            >
              <DescriptionList size="small" col="1">
                <Description term="Name">
                  {metricDetail.name}
                </Description>
                <Description term="Value Type">
                  <RadioGroup onChange={this.handleMetricValueType} value={metricValueType}>
                    <Radio value="string">String</Radio>
                    <Radio value="time">Time</Radio>
                    <Radio value="memory">Memory</Radio>
                  </RadioGroup>
                </Description>
                <Description term="Value">
                  {
                    metricValueType === 'memory' ? prettyBytes(metricDetail.measurements[0].value)
                        : metricValueType === 'time' ? moment(metricDetail.measurements[0].value).format('YYYY-MM-DD HH:MM:ss')
                        : metricDetail.measurements[0].value
                  }
                </Description>
              </DescriptionList>
            </Modal>
          ) : null
        }
      </Card>
    );
  }
}
