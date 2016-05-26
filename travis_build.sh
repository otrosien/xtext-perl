#!/bin/bash

set -ev
if [ "$TRAVIS_OS_NAME" == "osx" ]; then
	if [ "${TRAVIS_PULL_REQUEST}" != "false" ]; then
		echo "Build on MacOSX: Pull Request"
		./mvnw clean verify
	else
		echo "Skipping build on MacOSX for standard commit"
	fi
else
	echo "Build on Linux"
	./mvnw clean verify || exit 1
	./gradlew clean build || exit 1
fi 
