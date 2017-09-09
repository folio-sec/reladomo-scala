#!/bin/bash
sbt clean "project reladomoScalaCommon" +publishLocal 
export TWITTER_UTIL_VERSION=6.43.0;sbt clean "project reladomoScalaTwitterCommon" +publishLocal
export TWITTER_UTIL_VERSION=6.45.0;sbt clean "project reladomoScalaTwitterCommon" +publishLocal
export TWITTER_UTIL_VERSION=7.0.0; sbt clean "project reladomoScalaTwitterCommon" +publishLocal

sbt clean "project sbtReladomoPlugin" "^publishLocal"
