#!/bin/bash
nohup java ${JAVA_OPTS} -jar /app/${MODULE}.jar --server.port=8999  &
while [[ true ]]; do
    sleep 1
done