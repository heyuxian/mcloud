import React from 'react';
import { Card, Row, Col, Menu, Dropdown, Icon } from 'antd';
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
    this.fetchMetrics(instanceId);
    this.state.timer = setInterval(() => this.fetchMetrics(instanceId), 2500);
  }

  componentWillUnmount() {
    if (this.state.timer) {
      clearTimeout(this.state.timer);
    }
  }

  fetchMetrics = instanceId => {
    this.props.dispatch({
      type: 'details/fetchMemory',
      payload: {
        instanceId,
      },
    });
  };

  render() {
    const { details: { build, memory } } = this.props;
    const loaded = memory.heap && memory.nonheap;

    const menu = (
      <Menu>
        <Menu.Item>Heapdump</Menu.Item>
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
          <Card title="Application" extra={iconGroup}>
            <DescriptionList size="small" col="2">
              <Description term="Name">{build.name}</Description>
              <Description term="Group">{build.group}</Description>
              <Description term="Artifact">{build.artifact}</Description>
              <Description term="Build time">{build.time}</Description>
              <Description term="Version">{build.version}</Description>
            </DescriptionList>
          </Card>
        </Col>
        <Col xl={12} lg={12} md={24} sm={24} xs={24}>
          <Card title="Memory" loading={!loaded} bodyStyle={{ textAlign: 'center' }}>
            {loaded ? (
              <Row>
                <Col md={8} sm={12} xs={24}>
                  <DescriptionList size="small" col="1">
                    <Description term="Heap Memory">
                      {prettyBytes(memory.heap.used)}/{prettyBytes(memory.heap.max)}
                    </Description>
                    <Description term="Non-Heap Memory">
                      {prettyBytes(memory.nonheap.used)}/{prettyBytes(memory.nonheap.max)}
                    </Description>
                    <Description term="Metaspace">
                      {prettyBytes(memory.nonheap.metaspace)}
                    </Description>
                  </DescriptionList>
                </Col>
                <Col md={8} sm={12} xs={24}>
                  <WaterWave
                    height={161}
                    title={
                      <span>
                        <b>Heap</b>
                        <br />
                        <span>
                          {prettyBytes(memory.heap.used)}/{prettyBytes(memory.heap.max)}
                        </span>
                      </span>
                    }
                    percent={(memory.heap.used / memory.heap.max).toFixed(2)}
                  />
                </Col>
                <Col md={8} sm={12} xs={24}>
                  <WaterWave
                    height={161}
                    title={
                      <span>
                        <b>Non Heap</b>
                        <br />
                        <span>
                          {prettyBytes(memory.nonheap.used)}/{prettyBytes(memory.nonheap.max)}
                        </span>
                      </span>
                    }
                    percent={(memory.nonheap.used / memory.nonheap.max).toFixed(2)}
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
