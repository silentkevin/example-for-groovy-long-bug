#!/bin/bash

set -e -x

docker build -t example-for-groovy-bug:latest -f docker/Dockerfile .

docker kill example-for-groovy-bug || true
docker rm example-for-groovy-bug || true
docker run --name example-for-groovy-bug example-for-groovy-bug:latest
