import React, { PureComponent, Fragment } from 'react';
import { connect } from 'dva';
import { Row, Col, Card, List, Divider, Tag, Icon } from 'antd';
import DescriptionList from 'components/DescriptionList';

const { Description } = DescriptionList;

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
        <Card title={app.name} bordered>
          <DescriptionList size="small" col="2">
            <Description term={<b>AMIs</b>}>
              {app.amiCounts
                .map(obj => {
                  let value;
                  for (const key in obj) {
                    if (Object.prototype.hasOwnProperty.call(obj, key)) {
                      value = `${key}  (${obj[key]})`;
                    }
                  }
                  return value;
                })
                .join(',')}
            </Description>
            <Description term={<b>Availability Zones</b>}>
              {app.zoneCounts
                .map(obj => {
                  let value;
                  for (const key in obj) {
                    if (Object.prototype.hasOwnProperty.call(obj, key)) {
                      value = `${key}  (${obj[key]})`;
                    }
                  }
                  return value;
                })
                .join(',')}
            </Description>
          </DescriptionList>
          <Divider />
          <List
            size="small"
            header={app.instanceInfos.name}
            dataSource={app.instanceInfos}
            renderItem={item => (
              <List.Item
                actions={[
                  <a href={item.instances[0].url} target="_blank">
                    <Icon type="export" />
                  </a>,
                ]}
              >
                {<Tag color="#87d068">{item.status}</Tag>}
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
