#!/bin/sh -ex

curl -XGET http://localhost:8082/55592020 -s | jq .
