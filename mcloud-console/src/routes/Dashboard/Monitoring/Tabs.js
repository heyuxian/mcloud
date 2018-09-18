import React, { PureComponent } from 'react';
import { routerRedux, Route, Switch } from 'dva/router';
import { connect } from 'dva';
import PageHeaderLayout from '../../../layouts/PageHeaderLayout';
import { getRoutes } from '../../../utils/utils';

@connect()
export default class Monitoring extends PureComponent {
  handleTabChange = key => {
    const { dispatch, match } = this.props;
    dispatch(routerRedux.push(`${match.url}/${key}`));
  };

  render() {
    const tabList = [
      {
        key: 'details',
        tab: 'Details',
      },
      {
        key: 'metrics',
        tab: 'Metrics',
      },
      {
        key: 'environment',
        tab: 'Environment',
      },
      {
        key: 'logging',
        tab: 'Logging',
      },
      {
        key: 'jmx',
        tab: 'JMX',
      },
      {
        key: 'threads',
        tab: 'Threads',
      },
      {
        key: 'trace',
        tab: 'Trace',
      },
      {
        key: 'hystrix',
        tab: 'Hystrix',
      },
    ];
    const { match, routerData, location } = this.props;
    const routes = getRoutes(match.path, routerData);
    return (
      <PageHeaderLayout
        title="Monitoring"
        tabList={tabList}
        tabActiveKey={location.pathname.replace(`${match.url}/`, '')}
        onTabChange={this.handleTabChange}
      >
        <Switch>
          {routes.map(item => (
            <Route key={item.key} path={item.path} component={item.component} exact={item.exact} />
          ))}
        </Switch>
      </PageHeaderLayout>
    );
  }
}
