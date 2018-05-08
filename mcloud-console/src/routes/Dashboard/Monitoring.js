import React, { PureComponent, Fragment } from 'react';
import { connect } from 'dva';
import { Row, Col, Card, List, Tag, Icon } from 'antd';

@connect(({ monitoring, loading }) => ({
  monitoring,
  loading: loading.models.monitor,
}))
export default class Monitoring extends PureComponent {
  componentDidMount() {
    this.props.dispatch({
      type: 'monitoring/fetchApps',
    });
  }

  renderApps = app => {
    return (
      <Col span={8} key={app.name}>
        <Card title={app.name}>
          <List
            size="small"
            dataSource={app.instances}
            renderItem={item => (
              <List.Item
                actions={[
                  <a href={item.statusPageUrl} target="_blank">
                    <Icon type="export" />
                  </a>,
                ]}
              >
                {
                  <span>
                    <Tag color="#87d068">{item.status}</Tag> {item.instanceId}
                  </span>
                }
              </List.Item>
            )}
          />
        </Card>
      </Col>
    );
  };

  render() {
    const { monitoring } = this.props;
    const { apps } = monitoring;

    return (
      <Fragment>
        <Row gutter={24}>{apps.map(app => this.renderApps(app))}</Row>
      </Fragment>
    );
  }
}
