// Snowpack Configuration File
// See all supported options: https://www.snowpack.dev/reference/configuration

const developmentMode = process.env.NODE_ENV === 'development'

const scalaVersion = '2.13'
// const scalaVersion = '3.0.0-M3'

const sbtProjectName = 'root'
const scalaJsOptMode = developmentMode ? 'fastopt' : 'opt'

let mount = {
  'src/main/static/stylesheets': '/',
  'src/main/static/fonts': {url: '/fonts/', static: true, resolve: false},
  'src/main/static/html': '/',
}
mount[`target/scala-${scalaVersion}/${sbtProjectName}-${scalaJsOptMode}`] = '/'

let plugins = [
  "@snowpack/plugin-postcss",
]
if (!developmentMode) {
  plugins.push(
    ["snowpack-plugin-content-hash", {
      exts: [".js", ".css"], // Extensions of files to be affected by this plugin. Note: only .js or .jsx are valid extensions.
      silent: true, // Provide log output during build process. Default: true.
      hashLength: 8, // Specify the max length of the resulting hash string. Defaults to 0 for the full length.
      hashAlgorithm: "sha256", // Specify the hash algorithm. Defaults to md5.
    }]
  )
}

/** @type {import('snowpack').SnowpackUserConfig } */
module.exports = {
  mount,
  plugins,
  "routes": [
    {"match": "routes", "src": ".*", "dest": "/index.html"}
  ],
  packageOptions: {
    /* ... */
  },
  devOptions: {
    /* ... */
  },
  buildOptions: {
    /* ... */
  },
  alias: {
    'stylesheets': './src/main/static/stylesheets',
  }
};
