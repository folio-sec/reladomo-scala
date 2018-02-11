import Dependencies.reladomoBinVersion

//scripted-plugin requires SNAPSHOT version since it publishes to local ivy in every test runs
version in ThisBuild := s"${reladomoBinVersion}.0-SNAPSHOT"
