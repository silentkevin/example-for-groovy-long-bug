#!/bin/bash

set -e -x

ls -lah
pwd
export | sort

./gradlew --no-daemon --info build test check
