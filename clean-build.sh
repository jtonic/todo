#!/usr/bin/env bash

kubectl delete all --all -n todo && \
kubectl replace --force -f ./k8s/todo-namespace.yaml && \
kubectl config set-context "$(kubectl config current-context)" --namespace todo && \
eval "$(minikube docker-env)" && \
docker build -t todo-zulu-alpine-jre-11 -f ./be/Dockerfile ./be && \
docker build -t todo-fe-alpine-ngnix-vue -f ./fe/Dockerfile ./fe && \
kubectl replace --force -f ./be/k8s && \
kubectl replace --force -f ./fe/k8s && \
eval "$(minikube docker-env -u)" && \
kubectl get all -o wide
