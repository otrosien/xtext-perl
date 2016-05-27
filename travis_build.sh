#!/bin/bash

set -ev
echo "Build on Linux"
./mvnw clean verify || exit 1
./gradlew clean build || exit 1
