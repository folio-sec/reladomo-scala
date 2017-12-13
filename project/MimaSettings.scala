import sbt._, Keys._
import com.typesafe.tools.mima.plugin.MimaPlugin
import com.typesafe.tools.mima.plugin.MimaKeys.{mimaPreviousArtifacts, mimaReportBinaryIssues}

object MimaSettings {

  // The `previousVersions` must be *ALL* the previous versions to be binary compatible (e.g. Set("16.6.0", "16.6.1") for "16.6.2-SNAPSHOT").
  // The following bad scenario is the reason we must obey the rule:
  //  - your build is toward 16.6.2 release and the `previousVersions` is "16.6.0" only
  //  - you've added new methods since 16.6.1
  //  - you're going to remove some of the methods in 16.6.2
  //  - in this case, the incompatibility won't be detected
  // val previousVersions = Set.empty
  val previousVersions = if(sys.env.get("TWITTER_UTIL_VERSION") == "17.12.0") {
    // because first release for this twitter util version, no binary compatbile check
    Set.empty
  } else {
    Set(0, 1).map(patch => s"16.6.$patch")
  }

  val mimaSettings = MimaPlugin.mimaDefaultSettings ++ Seq(
    mimaPreviousArtifacts := {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, scalaMajor)) if scalaMajor <= 12 => previousVersions.map { organization.value % s"${normalizedName.value}_${scalaBinaryVersion.value}" % _ }
        case _ => Set.empty
      }
    },
    test in Test := {
      mimaReportBinaryIssues.value
      (test in Test).value
    }
  )
}
