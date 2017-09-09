sys.props.get("plugin.version") match {
  case Some(pluginVersion) =>
    addSbtPlugin("com.folio-sec"   % "sbt-reladomo-plugin" % pluginVersion)
  case _ => sys.error("""|The system property 'plugin.version' is not defined.
                         |Specify this property using the scriptedLaunchOpts -Dplugin.version.""".stripMargin)
}
