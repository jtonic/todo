# Objectives

## Prerequisites

- node 10+ installed

### Action steps

- [x] Run the application locally

    `npm run serve`

- [x] Test the locally run application

    The command above should open the default browser pointing the application.
    If not the command write in the console the url where the application could be accessed.

- [x] Create a todo-fe image (latest, v1)

    `docker build -t todo-fe-alpine-ngnix-vue .`

- [x] Run a container based on the newly created image

    `docker run -d -p 8080:80 --name todo-fe-alpine-ngnix-vue todo-fe-alpine-ngnix-vue`

- [x] Test the todo-fe application by pointing the browser to `http://localhost:8080`

- [x] Push the image on hub.docker.io/jtonic

  ```shell script
  docker login
  docker tag todo-fe-alpine-ngnix-vue jtonic/todo-fe-alpine-ngnix-vue
  docker tag todo-fe-alpine-ngnix-vue jtonic/todo-fe-alpine-ngnix-vue:v1
  docker push jtonic/todo-fe-alpine-ngnix-vue
  docker push jtonic/todo-fe-alpine-ngnix-vue:v1
  ```

  > Notes: For development on local it is better to use local image.
  >
  > But a kubernetes cluster (i.e. minikube) use its docker (not the host docker) to pull the images.
  > Read [this cookbook to see how to do this](../docs/cookbooks/cloud.md#recipe-1)

- [x] Update the k8s configuration to refer the newly published image

- [x] Start the minikube

    `minikube start`

- [x] Run container in minikube cluster (one node)

    `kubectl create -f ./k8s/todo-fe-service-deployment.yaml`

- [x] or replace the service/deployment

    `kubectl replace --force -f ./k8s/todo-fe-service-deployment.yaml`

- [ ] Test the kubernetes based application

    Point the browser to the output of `minikube service todo-fe --url`

## Best practices

 See [here](../docs/best_practices/cloud.md)
