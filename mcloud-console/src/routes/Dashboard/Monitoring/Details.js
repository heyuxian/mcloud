import React from 'react';
import { Card, Row, Col, Menu, Dropdown, Icon, Divider } from 'antd';
import { connect } from 'dva';
import prettyBytes from 'pretty-bytes';
import DescriptionList from 'components/DescriptionList';
import { WaterWave } from 'components/Charts';
import styles from './Monitoring.less';

const { Description } = DescriptionList;

@connect(({ details, loading }) => ({
  details,
  loading: loading.models.details,
}))
export default class Details extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      timer: null,
    };
  }

  componentDidMount() {
    const { instanceId } = this.props.match.params;
    this.props.dispatch({
      type: 'details/fetchAppInfo',
      payload: {
        instanceId,
      },
    });
    this.props.dispatch({
      type: 'details/fetchMaxMemory',
      payload: {
        instanceId,
      },
    });
    this.fetchMetrics(instanceId);
    this.state.timer = setInterval(() => this.fetchMetrics(instanceId), 10000);
  }

  componentWillUnmount() {
    if (this.state.timer) {
      clearTimeout(this.state.timer);
    }
  }

  fetchMetrics = instanceId => {
    this.props.dispatch({
      type: 'details/fetchUsedMemory',
      payload: {
        instanceId,
      },
    });
  };

  render() {
    const { instanceId } = this.props.match.params;
    const { details: { build, memory } } = this.props;
    const memoryLoaded =
      memory.max &&
      memory.max.heap &&
      memory.max.heap.value &&
      memory.used &&
      memory.used.heap &&
      memory.used.heap.value;
    const buildLoaded = build && build.name;
    const menu = (
      <Menu>
        <Menu.Item key="Heapdump">
          <a href={`/api/v1/registry/instances/${instanceId}/actuator/heapdump`}>Heapdump</a>
        </Menu.Item>
      </Menu>
    );

    const iconGroup = (
      <span className={styles.iconGroup}>
        <Dropdown overlay={menu} placement="bottomRight">
          <Icon type="ellipsis" />
        </Dropdown>
      </span>
    );

    return (
      <Row gutter={24}>
        <Col xl={12} lg={12} md={24} sm={24} xs={24}>
          <Card title="Application" loading={!buildLoaded}>
            {buildLoaded ? (
              <DescriptionList size="small" col="2">
                <Description term="Name">{build.name}</Description>
                <Description term="Group">{build.group}</Description>
                <Description term="Artifact">{build.artifact}</Description>
                <Description term="Build time">{build.time}</Description>
                <Description term="Version">{build.version}</Description>
              </DescriptionList>
            ) : null}
          </Card>
        </Col>
        <Col xl={12} lg={12} md={24} sm={24} xs={24}>
          <Card
            title="Memory"
            loading={!memoryLoaded}
            bodyStyle={{ textAlign: 'center' }}
            extra={iconGroup}
          >
            {memoryLoaded ? (
              <Row>
                <Col md={12} sm={12} xs={24}>
                  <DescriptionList size="small" col="1">
                    <Description term="Heap Memory">
                      {prettyBytes(memory.used.heap.value)}
                      /
                      {prettyBytes(memory.max.heap.value)}
                    </Description>
                    <Description term="Eden Space">
                      {prettyBytes(memory.used.heap.edenSpace)}
                      /
                      {prettyBytes(memory.max.heap.edenSpace)}
                    </Description>
                    <Description term="Survivor Space">
                      {prettyBytes(memory.used.heap.survivorSpace)}
                      /
                      {prettyBytes(memory.max.heap.survivorSpace)}
                    </Description>
                    <Description term="Old Gen">
                      {prettyBytes(memory.used.heap.oldGen)}
                      /
                      {prettyBytes(memory.max.heap.oldGen)}
                    </Description>
                    <Divider />
                    <Description term="Non-Heap Memory">
                      {prettyBytes(memory.used.nonheap.value)}
                      /
                      {prettyBytes(memory.max.nonheap.value)}
                    </Description>
                    <Description term="Metaspace">
                      {prettyBytes(memory.used.nonheap.metaspace)}
                      /
                      {prettyBytes(memory.max.nonheap.metaspace)}
                    </Description>
                    <Description term="Compressed Class Space">
                      {prettyBytes(memory.used.nonheap.compressedClassSpace)}
                      /
                      {prettyBytes(memory.max.nonheap.compressedClassSpace)}
                    </Description>
                    <Description term="Code Cache">
                      {prettyBytes(memory.used.nonheap.codeCache)}
                      /
                      {prettyBytes(memory.max.nonheap.codeCache)}
                    </Description>
                  </DescriptionList>
                </Col>
                <Col md={6} sm={12} xs={24}>
                  <WaterWave
                    height={161}
                    title={
                      <span>
                        <b>Heap</b>
                        <br />
                        <span>
                          {prettyBytes(memory.used.heap.value)}/{prettyBytes(memory.max.heap.value)}
                        </span>
                      </span>
                    }
                    percent={(memory.used.heap.value / memory.max.heap.value).toFixed(2)}
                  />
                </Col>
                <Col md={6} sm={12} xs={24}>
                  <WaterWave
                    height={161}
                    title={
                      <span>
                        <b>Non Heap</b>
                        <br />
                        <span>
                          {prettyBytes(memory.used.nonheap.value)}/{prettyBytes(
                            memory.max.nonheap.value
                          )}
                        </span>
                      </span>
                    }
                    percent={(memory.used.nonheap.value / memory.max.nonheap.value).toFixed(2)}
                  />
                </Col>
              </Row>
            ) : null}
          </Card>
        </Col>
      </Row>
    );
  }
}
