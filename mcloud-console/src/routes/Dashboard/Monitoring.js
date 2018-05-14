import React, { PureComponent } from 'react';
import { Route, Switch } from 'dva/router';
import { connect } from 'dva';
import { getRoutes } from '../../utils/utils';
import List from './Monitoring/List';

@connect()
export default class Monitoring extends PureComponent {
  componentDidMount() {
    this.props.dispatch({
      type: 'application/fetchApps',
    });
  }

  render() {
    const { match, routerData } = this.props;
    const routes = getRoutes(match.path, routerData);
    return (
      <Switch>
        {routes.map(item => (
          <Route key={item.key} path={item.path} component={item.component} exact={item.exact} />
        ))}
        <Route exact path="/console/monitoring" component={List} />
      </Switch>
    );
  }
}
