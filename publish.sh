#!/bin/bash
sbt clean "project reladomoScalaCommon" +publishSigned
export TWITTER_UTIL_VERSION=7.1.0
sbt clean "project reladomoScalaTwitterCommon" +publishSigned
export TWITTER_UTIL_VERSION=17.10.0
sbt clean "project reladomoScalaTwitterCommon" +publishSigned
export TWITTER_UTIL_VERSION=17.11.0
sbt clean "project reladomoScalaTwitterCommon" +publishSigned
export TWITTER_UTIL_VERSION=17.12.0
sbt clean "project reladomoScalaTwitterCommon" +publishSigned
sbt clean "project sbtReladomoPlugin" "^publishSigned"
