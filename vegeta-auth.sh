#!/bin/sh -ex

cat payment-request-vegeta | vegeta attack -rate 10 -duration=5s  | vegeta report -reporter=text
