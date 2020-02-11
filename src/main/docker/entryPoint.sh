#!/bin/bash

set -e

echo "Entry Point"

appid=$(echo $MESOS_TASK_ID |  cut -d. -f1)
taskid=$(echo $MESOS_TASK_ID |  cut -d. -f2)
export taskid
export appid

echo "JAVA_OPTS: $JAVA_OPTS"
echo "JMX_CONFIG: $JMX_CONFIG"

exec java $JAVA_OPTS $JMX_CONFIG -jar app.jar