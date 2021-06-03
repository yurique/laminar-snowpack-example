import org.scalajs.linker.interface.ModuleSplitStyle

ThisBuild / scalaVersion := ScalaVersions.v213
//ThisBuild / scalaVersion := ScalaVersions.v3

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
    scalaJSLinkerConfig ~= { _.withSourceMap(true) },
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "com.raquo"     %%% "laminar"              % "0.13.0",
      "io.frontroute" %%% "frontroute"           % "0.13.1",
      "io.laminext"   %%% "core"                 % "0.13.3",
      "com.yurique"   %%% "embedded-files-macro" % "0.2.4"
    ),
    embedTextGlobs := Seq("**/*.md"),
    (Compile / sourceGenerators) += embedFiles
  )
