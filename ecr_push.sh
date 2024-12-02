#!/bin/bash
# ECR Push Script
docker tag wooribound/server:latest ${ECR_URI}/wooribound:server-latest
docker push ${ECR_URI}/wooribound:server-latest