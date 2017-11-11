import Dependencies._
import Publishing._

lazy val theOrganization = "com.folio-sec"

lazy val baseSettings = Seq(
  organization := theOrganization,
  scalacOptions ++= theScalaOptions,
  incOptions := xsbti.compile.IncOptions.of(),
  transitiveClassifiers in Global := Seq(Artifact.SourceClassifier),
  pomIncludeRepository := (_ => false),
  scalafmtOnCompile := true,
  fork in Test := true,
  pomExtra := thePomExtra,
  publishTo := doPublishTo(version.value)
)

lazy val reladomoScalaCommon = (project in file("reladomo-scala-common"))
  .disablePlugins(ScriptedPlugin)
  .settings(baseSettings)
  .settings(
    name := "reladomo-scala-common",
    scalaVersion := latestScalaVersion,
    crossScalaVersions := Seq(latestScalaVersion, "2.11.11"),
    sbtPlugin := false,
    libraryDependencies ++= Seq(
      reladomo,
      slf4jApi,
      jodaTime,
      jodaConvert,
      scalikejdbc,
      h2,
      logbackClassic,
      scalaTest
    ),
    // env variables for unit tests
    envVars in Test := Map("RELADOMO_SCALA_SIMPLE_BANK_PASSWORD" -> "pass")
  )
  .settings(MimaSettings.mimaSettings)

lazy val reladomoScalaTwitterCommon = (project in file("reladomo-scala-twitter-common"))
  .disablePlugins(ScriptedPlugin)
  .settings(baseSettings)
  .settings(
    normalizedName := s"reladomo-scala-twitter-${twitterUtilBinVersion}-common",
    scalaVersion := latestScalaVersion,
    crossScalaVersions := Seq(latestScalaVersion, "2.11.11"),
    sbtPlugin := false,
    libraryDependencies ++= Seq(
      twitterUtilCore,
      scalikejdbc,
      h2,
      logbackClassic,
      scalaTest
    )
  )
  .dependsOn(reladomoScalaCommon)
  .settings(MimaSettings.mimaSettings)

lazy val sbtReladomoPlugin = (project in file("sbt-reladomo-plugin"))
  .settings(baseSettings)
  .settings(
    name := "sbt-reladomo-plugin",
    crossSbtVersions := Vector("0.13.16", "1.0.1"),
    sbtPlugin := true,
    libraryDependencies ++= Seq(
      ant,
      reladomo,
      slf4jApi,
      jodaTime,
      jodaConvert,
      reladomogen,
      reladomogenUtil,
      scalaTest
    ),
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
      Seq(
        "-Xmx1024M",
        "-Dplugin.version=" + version.value,
        "-DreladomoScalaCommonVersion=" + version.value
      )
    },
    scriptedBufferLog := false
  )
