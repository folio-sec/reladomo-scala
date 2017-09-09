import com.folio_sec.reladomo.generator.sbtplugin.ReladomoPlugin

lazy val reladomoV           = "16.5.1"
lazy val twitterUtilCoreBinV  = "6.45"
lazy val theOrganization     = "com.folio-sec"

lazy val common = (project in file("common"))
  .settings(
    scalaVersion := "2.12.3",
    reladomoScalaApiFutureType in Compile := "twitter",
    libraryDependencies ++= Seq(
      theOrganization             %% "reladomo-scala-common"                                 % System.getProperty("reladomoScalaCommonVersion"),
      theOrganization             %% s"reladomo-scala-twitter-${twitterUtilCoreBinV}-common" % System.getProperty("reladomoScalaCommonVersion"),
      "com.goldmansachs.reladomo" % "reladomo"                                               % reladomoV
    )
  )
  .dependsOn(other)
  .enablePlugins(ReladomoPlugin)

lazy val other = (project in file("other")).settings(scalaVersion := "2.12.3")
