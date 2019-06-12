#!/bin/sh -ex

curl -XGET http://localhost:8081/auth-token1 -s | jq .
