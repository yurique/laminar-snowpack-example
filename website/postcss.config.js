module.exports = () => {
  const plugins = {
    'postcss-import': {},
    tailwindcss: require('./tailwind.config'),
    autoprefixer: {}
  }
  if (process.env.NODE_ENV === 'production') {
    plugins['cssnano'] = {}
  }
  return {
    plugins
  }
}
