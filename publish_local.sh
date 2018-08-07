#!/bin/bash
sbt clean "project reladomoScalaCommon" +publishLocal
export TWITTER_UTIL_VERSION=18.7.0; sbt clean "project reladomoScalaTwitterCommon" +publishLocal
export TWITTER_UTIL_VERSION=18.6.0; sbt clean "project reladomoScalaTwitterCommon" +publishLocal
export TWITTER_UTIL_VERSION=18.5.0; sbt clean "project reladomoScalaTwitterCommon" +publishLocal
sbt clean "project sbtReladomoPlugin" "^publishLocal"
