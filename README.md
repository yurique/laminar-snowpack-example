# laminar-snowpack-example

An example of a [snowpack](https://www.snowpack.dev/) build for a [Scala.js](https://scala-js.org) + [Laminar](https://github.com/raquo/Laminar) +
[frontroute](https://github.com/tulz-app/frontroute) app.

Note that Snowpack is not a fit for every project:

> Snowpack is a lightning-fast frontend build tool, designed for the modern web. 
> It is an alternative to heavier, more complex bundlers like webpack or Parcel 
> in your development workflow. Snowpack leverages JavaScript's native module
> system (known as ESM) to avoid unnecessary work and stay fast no matter
> how big your project grows.

## embedded-files

This app also demonstrates how to use the [embedded-files](https://github.com/yurique/embedded-files/) – sbt plugin and
the macro – to effectively achieve "resources" in Scala.js.

## tailwindcss

The app is styled with [tailwindcss](https://tailwindcss.com/).

For this, the [PostCSS](https://postcss.org/) plugin for Snowpack is installed, and PostCSS 
is configured to run the tailwindcss plugin (as well as the [postcss-preset-env](https://preset-env.cssdb.org/) plugin).

When building a production release, PostCSS will also run the [CSSNANO](https://cssnano.co/) plugin and tailwindcss plugin
will also purge the unused classes from the generated `.css` file.

## installing npm dependencies

```console
$ yarn install
```

## dev server

In sbt:
```
sbt:laminar-snowpack-example> fastLinkJS
// OR, if you want sbt to watch the source changes and rebuild continuosly
sbt:laminar-snowpack-example> ~fastLinkJS
```

Then, start the Snowpack dev server (from a terminal – this is *not* a sbt command):

```console
$ yarn run snowpack dev
```

## production build

In sbt:
```
sbt:laminar-snowpack-example> fullLinkJS
```

Run the Snowpack `build` command:

```console
$ yarn run snowpack build
```

The assets will end up in the `build` directory.

(main.js – `1.5M`, with brotli - `130K`, with gzip – `188K`)

## Scala 3

You can build this app with Scala 3:

* uncomment the corresponging line in the `build.sbt` (and comment the other one)
* do the same in the `snowpack.config.js`
* restart sbt and Snowpack, and follow the steps above

