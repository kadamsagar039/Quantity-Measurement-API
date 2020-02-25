#!/bin/bash

source /var/jenkins_home/maven/maven.sh
mvn clean verify sonar:sonar
