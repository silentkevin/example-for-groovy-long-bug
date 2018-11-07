#!/bin/bash

set -e -x

docker build -t example-for-groovy-long-bug:latest -f docker/Dockerfile .

docker kill example-for-groovy-long-bug || true
docker rm example-for-groovy-long-bug || true
docker run --name example-for-groovy-long-bug example-for-groovy-long-bug:latest
