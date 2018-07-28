import com.folio_sec.reladomo.generator.sbtplugin.ReladomoPlugin

lazy val reladomoV           = "17.0.2"
lazy val twitterUtilCoreBinV = "18.7"
lazy val theOrganization     = "com.folio-sec"

lazy val root = (project in file("."))
  .settings(
    scalaVersion := "2.12.6",
    reladomoScalaApiFutureType in Compile := "twitter",
    libraryDependencies ++= Seq(
      theOrganization             %% "reladomo-scala-common"                                 % System.getProperty("reladomoScalaCommonVersion"),
      theOrganization             %% s"reladomo-scala-twitter-${twitterUtilCoreBinV}-common" % System.getProperty("reladomoScalaCommonVersion"),
      "com.goldmansachs.reladomo" % "reladomo"                                               % reladomoV,
      "com.goldmansachs.reladomo" % "reladomo-serial"                                        % reladomoV   % Test,
      "com.goldmansachs.reladomo" % "reladomo-test-util"                                     % reladomoV   % Test
    )
  )
  .enablePlugins(ReladomoPlugin)
