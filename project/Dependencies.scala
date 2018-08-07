import sbt._

object Dependencies {
  def toBinV(v: String) = v.split("\\.").init.mkString(".")

  lazy val latestScalaVersion = "2.12.6"

  lazy val twitterUtilVersion    = sys.env.get("TWITTER_UTIL_VERSION").getOrElse("18.7.0")
  lazy val twitterUtilBinVersion = toBinV(twitterUtilVersion)
  lazy val reladomoVersion     = "17.0.2"
  lazy val reladomoBinVersion = toBinV(reladomoVersion)

  lazy val reladomo        = "com.goldmansachs.reladomo" % "reladomo" % reladomoVersion % Compile excludeAll(
                               ExclusionRule("joda-time", "joda-time"),
                               ExclusionRule("org.slf4j", "slf4j-api")
                             )
  lazy val reladomogen     = "com.goldmansachs.reladomo" % "reladomogen" % reladomoVersion % Compile
  lazy val reladomogenUtil = "com.goldmansachs.reladomo" % "reladomo-gen-util" % reladomoVersion % Compile excludeAll(
                               ExclusionRule("com.goldmansachs.reladomo", "reladomo")
                             )
  lazy val twitterUtilCore = "com.twitter"       %% "util-core"             % twitterUtilVersion % Compile
  lazy val slf4jApi        = "org.slf4j"         %  "slf4j-api"             % "1.7.25"  % Compile
  lazy val jodaTime        = "joda-time"         %  "joda-time"             % "2.10"    % Compile
  lazy val jodaConvert     = "org.joda"          %  "joda-convert"          % "2.1.1"   % Compile
  lazy val scalikejdbc     = "org.scalikejdbc"   %% "scalikejdbc"           % "3.3.0"   % Test
  lazy val h2              = "com.h2database"    %  "h2"                    % "1.4.197" % Test
  lazy val logbackClassic  = "ch.qos.logback"    %  "logback-classic"       % "1.2.3"   % Test
  // reladomo generator depends on ant
  lazy val ant             = "org.apache.ant"    %  "ant"                   % "1.10.1"  % Compile
  lazy val scalaTest       = "org.scalatest"     %% "scalatest"             % "3.0.5"   % Test
}
