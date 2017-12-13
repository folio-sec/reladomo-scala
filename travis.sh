#!/bin/bash
if [[ ${TRAVIS_SCALA_VERSION} = "scripted-test" ]]; then
  sbt clean "project reladomoScalaCommon" +publishLocal \
  && export TWITTER_UTIL_VERSION=17.12.0 \
  && sbt clean "project reladomoScalaTwitterCommon" +publishLocal \
  && export TWITTER_UTIL_VERSION=17.11.0 \
  && sbt clean "project reladomoScalaTwitterCommon" +publishLocal \
  && export TWITTER_UTIL_VERSION=17.10.0 \
  && sbt clean "project reladomoScalaTwitterCommon" +publishLocal \
  && export TWITTER_UTIL_VERSION=7.1.0 \
  && sbt clean "project reladomoScalaTwitterCommon" +publishLocal \
  && sbt clean \
      "project sbtReladomoPlugin" \
      "test" \
      "^scripted" \
      "^publishLocal" \
  && cd sample && sbt clean test
else
  sbt ++${TRAVIS_SCALA_VERSION} \
      clean \
      "scalafmt::test" \
      "test:scalafmt::test" \
      "sbt:scalafmt::test" \
      reladomoScalaCommon/test \
      reladomoScalaTwitterCommon/test
fi
