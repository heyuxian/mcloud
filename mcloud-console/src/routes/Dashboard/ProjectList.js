import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, List } from 'antd';

import Ellipsis from 'components/Ellipsis';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';

import styles from './Project.less';

const list = [
  {
    id: 1,
    title: 'Registry',
    avatar: '',
    description: 'MCloud Registry 是基于 Spring Cloud Eureka，实现了服务注册发现等功能。',
  },
  {
    id: 2,
    title: 'API Gateway',
    avatar: '',
    description:
      'MCloud 通过 API Gateway 给外部系统暴露 REST API。' +
      '系统中使用 Zuul 作为API Gateway。提供了动态路由、监控、回退、安全、API 限流等功能。',
  },
  {
    id: 3,
    title: 'OAuth2 认证服务',
    avatar: '',
    description: 'MCloud 使用了 keycloak 作为认证中心。',
  },
];
@connect(({ loading }) => ({
  loading: loading.models.list,
}))
export default class ProjectList extends PureComponent {
  componentDidMount() {
    this.props.dispatch({
      type: 'list/fetch',
      payload: {
        count: 8,
      },
    });
  }

  render() {
    const { loading } = this.props;

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
      <PageHeaderLayout title="MCloud 项目列表" content={content} extraContent={extraContent}>
        <div className={styles.cardList}>
          <List
            rowKey="id"
            loading={loading}
            grid={{ gutter: 24, lg: 3, md: 2, sm: 1, xs: 1 }}
            dataSource={list}
            renderItem={item => (
              <List.Item key={item.id}>
                <Card hoverable className={styles.card} actions={[<a>打开</a>]}>
                  <Card.Meta
                    avatar={<img alt="" className={styles.cardAvatar} src={item.avatar} />}
                    title={<a href="#">{item.title}</a>}
                    description={
                      <Ellipsis className={styles.item} lines={3}>
                        {item.description}
                      </Ellipsis>
                    }
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
