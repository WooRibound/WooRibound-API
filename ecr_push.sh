#!/bin/bash
# ECR Push Script
docker tag wooribound/server:latest ${REGISTRY_URI}/wooribound:server-latest
docker push ${REGISTRY_URI}/wooribound:server-latest
