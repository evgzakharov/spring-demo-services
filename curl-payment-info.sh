#!/bin/sh -ex

curl -XGET http://localhost:8083/1 -s | jq .
