#!/bin/sh -ex

curl -XGET http://localhost:8084/1 -s | jq .
