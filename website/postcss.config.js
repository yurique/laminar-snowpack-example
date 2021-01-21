module.exports = () => {
  return {
    plugins: [
      require('postcss-import')({}),
      process.env.NODE_ENV === 'production' ?
        require('tailwindcss')('./tailwind.prod.config.js') :
        require('tailwindcss')('./tailwind.dev.config.js'),
      require('postcss-preset-env')({}),
      process.env.NODE_ENV === 'production' ?
        require('cssnano')() :
        false
    ]
  };
}
