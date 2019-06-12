#!/bin/sh -ex

docker rmi service-auth:1.0.0

docker rmi service-card:1.0.0

docker rmi service-payment:1.0.0

docker rmi service-user:1.0.0
