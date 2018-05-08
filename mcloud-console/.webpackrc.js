const path = require('path');

export default {
  entry: 'src/index.js',
  extraBabelPlugins: [['import', { libraryName: 'antd', libraryDirectory: 'es', style: true }]],
  env: {
    development: {
      extraBabelPlugins: ['dva-hmr'],
    },
  },
  alias: {
    components: path.resolve(__dirname, 'src/components/'),
  },
  ignoreMomentLocale: true,
  theme: './src/theme.js',
  html: {
    template: './src/index.ejs',
  },
  disableDynamicImport: true,
  publicPath: '/',
  hash: true,
  proxy: {
    '/auth/': {
      target: 'http://localhost/auth/',
      changeOrigin: true,
      pathRewrite: { '^/auth/': '' },
    },
    '/registry/': {
      target: 'http://localhost/registry/',
      changeOrigin: true,
      pathRewrite: { '^/registry/': '' },
    },
  },
};
