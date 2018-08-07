#!/bin/bash
sbt clean "project reladomoScalaCommon" +publishSigned
export TWITTER_UTIL_VERSION=18.7.0
sbt clean "project reladomoScalaTwitterCommon" +publishSigned
export TWITTER_UTIL_VERSION=18.6.0
sbt clean "project reladomoScalaTwitterCommon" +publishSigned
export TWITTER_UTIL_VERSION=18.5.0
sbt clean "project reladomoScalaTwitterCommon" +publishSigned
sbt clean "project sbtReladomoPlugin" "^publishSigned"
