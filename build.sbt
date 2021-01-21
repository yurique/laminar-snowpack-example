import org.scalajs.linker.interface.ModuleSplitStyle

ThisBuild / scalaVersion := ScalaVersions.v213
//ThisBuild / scalaVersion := ScalaVersions.v3M3

lazy val basicSettings = Seq(
  scalacOptions ~= (_.filterNot(
    Set(
      "-Wdead-code",
      "-Wunused:implicits",
      "-Wunused:explicits",
      "-Wunused:imports",
      "-Wunused:params"
    )
  ))
)

lazy val root = project
  .in(file("website"))
  .enablePlugins(ScalaJSPlugin, EmbeddedFilesPlugin)
  .settings(basicSettings)
  .settings(
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
    scalaJSLinkerConfig ~= { _.withModuleSplitStyle(ModuleSplitStyle.FewestModules) },
    scalaJSLinkerConfig ~= { _.withSourceMap(false) },
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      ("com.raquo"     %%% "laminar"              % "0.11.0").withDottyCompat(scalaVersion.value),
      ("io.frontroute" %%% "frontroute"           % "0.11.7").withDottyCompat(scalaVersion.value),
      "com.yurique"    %%% "embedded-files-macro" % "0.2.0"
    ),
    embedTextGlobs := Seq("**/*.md"),
    (Compile / sourceGenerators) += embedFiles
  )
