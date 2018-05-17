import React, { PureComponent } from 'react';
import { routerRedux } from 'dva/router';
import { connect } from 'dva';
import { Card, List, Icon, Tag } from 'antd';

import PageHeaderLayout from '../../../layouts/PageHeaderLayout';

import styles from './Monitoring.less';

@connect(({ application, loading }) => ({
  application,
  loading: loading.models.application,
}))
export default class Index extends PureComponent {
  componentDidMount() {
    this.props.dispatch({
      type: 'application/fetchApps',
    });
  }

  handleItemClick = instanceId => {
    const { dispatch } = this.props;
    dispatch(routerRedux.push(`/console/monitoring/${instanceId}/details`));
  };

  render() {
    const { application: { apps }, loading } = this.props;

    const content = (
      <div className={styles.pageHeaderContent}>
        <p>MCloud 是基于 Spring Cloud 搭建的微服务平台。</p>
        <div className={styles.contentLink}>
          <a>
            <img alt="" src="https://gw.alipayobjects.com/zos/rmsportal/MjEImQtenlyueSmVEfUD.svg" />{' '}
            快速开始
          </a>
          <a>
            <img alt="" src="https://gw.alipayobjects.com/zos/rmsportal/NbuDUAuBlIApFuDvWiND.svg" />{' '}
            项目简介
          </a>
          <a>
            <img alt="" src="https://gw.alipayobjects.com/zos/rmsportal/ohOEPSYdDTNnyMbGuyLb.svg" />{' '}
            文档
          </a>
        </div>
      </div>
    );

    const extraContent = (
      <div className={styles.extraImg}>
        {/* <img
          alt="这是一个标题"
          src="https://gw.alipayobjects.com/zos/rmsportal/RzwpdLnhmvDJToTdfDPe.png"
        /> */}
      </div>
    );

    return (
      <PageHeaderLayout title="应用列表" content={content} extraContent={extraContent}>
        <div className={styles.cardList}>
          <List
            rowKey="id"
            loading={loading}
            grid={{ gutter: 24, lg: 3, md: 2, sm: 1, xs: 1 }}
            dataSource={apps}
            renderItem={app => (
              <List.Item key={app.name}>
                <Card hoverable className={styles.card}>
                  <Card.Meta title={<a href="#">{app.name}</a>} />
                  <List
                    size="small"
                    dataSource={app.instances}
                    renderItem={instance => (
                      <List.Item
                        actions={[
                          <a onClick={() => this.handleItemClick(instance.id)}>
                            <Icon type="export" />
                          </a>,
                        ]}
                      >
                        {
                          <span>
                            <Tag color="#87d068">{instance.statusInfo.status}</Tag> {instance.id}
                          </span>
                        }
                      </List.Item>
                    )}
                  />
                </Card>
              </List.Item>
            )}
          />
        </div>
      </PageHeaderLayout>
    );
  }
}
