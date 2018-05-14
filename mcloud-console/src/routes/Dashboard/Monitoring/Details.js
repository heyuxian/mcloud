import React from 'react';
import { Card, Row, Col } from 'antd';
import { connect } from 'dva';
import DescriptionList from 'components/DescriptionList';
import { Chart, Geom, Axis, Tooltip, Coord, Label, Legend, View, Guide, Shape } from 'bizcharts';

const { Description } = DescriptionList;

@connect(({ details, loading }) => ({
  details,
  loading: loading.models.details,
}))
export default class Details extends React.Component {
  componentDidMount() {
    const { instanceId } = this.props.match.params;
    this.props.dispatch({
      type: 'details/fetchAppInfo',
      payload: {
        instanceId,
      },
    });
    this.props.dispatch({
      type: 'details/fetchMetrics',
      payload: {
        instanceId,
        metric: 'jvm.memory.max',
        tags: {
          area: 'heap',
        },
      },
    });
  }
  render() {
    const { details: { build, memory } } = this.props;
    const cols = {
      time: {
        type: 'time',
        mask: 'HH:mm:ss',
        tickCount: 5,
      },
    };
    return (
      <Row gutter={24}>
        <Col xl={12} lg={12} md={24} sm={24} xs={24}>
          <Card title="Application">
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
          <Card title="Memory">
            <DescriptionList size="small" col="2">
              <Description term="Memory">{memory.name}</Description>
              <Description term="Heap Memory">{memory.name}</Description>
              <Description term="Initial Heap">{memory.name}</Description>
              <Description term="Maximum Heap">{memory.name}</Description>
              <Description term="Non-Heap Memory">{memory.name}</Description>
              <Description term="Initial Non-Heap">{memory.name}</Description>
              <Description term="Maximum Non-Heap">{memory.name}</Description>
            </DescriptionList>
          </Card>
        </Col>
        <Col xl={12} lg={12} md={24} sm={24} xs={24}>
          <Card title="Memory">
            <Chart data={memory} scale={cols} height={300}>
              <Axis name="max" />
              <Axis name="time" />
              <Legend />
              <Tooltip crosshairs={{ type: 'line' }} />
              <Geom type="area" position="time*max" color="name" />
              <Geom type="line" position="time*max" size={2} color="name" />
            </Chart>
          </Card>
        </Col>
      </Row>
    );
  }
}
