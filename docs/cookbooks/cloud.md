# Cloud related cookbook

__Description__

This is about how to do cloud related stuff.
I am going to consider aws cli, kubectl cli, minikube, docker cli.

## Recipe 1

### __Goal__ 

__How to use minikube internal docker to build local image so that the kubectl uses that local image.__
 
This is going to be very useful for local development, because it is no longer required to push the image to a private/public docker registry in order to be fetched by kubectl commands.

__About minikube:__ 
- Minikube is a virtual machine with a single node cluster. It comes with docker installed.
- The default strategy of minikube's docker is to pull images from remote docker registry.

###__Solution:__ 

There are many solutions but the straightforward one is to build the image from minikube's docker.

###__Steps__

- [optional] check the images on local host docker
    `docker image ls`
    
- [optional] check the image on minikube docker

    `minikube ssh`
    
    `docker image ls`
  
  > You will notice the images list are different  

- Setup local host docker to use the minikube's one

    `eval $(minikube docker-env)`
    
- Build the todo-be image

    `docker build -t todo-zulu-alpine-jre-11 .`
    
- Create a custom namespace for easy cleanup of the cluster new objects

    `kubectl create namespace todo-be-tmp`    
    
- Test minikube cluster with the todo-be pod(s) in dry-run mode

    `kubectl run todo-be-tmp --namespace=todo-be-tmp --image=todo-zulu-alpine-jre-11 --image-pull-policy=Never --port=9091 --labels="app=todo,env=prod" --generator=run-pod/v1 --dry-run`

- Test minikube cluster with the todo-be pod(s) for real

    `kubectl run todo-be-tmp --namespace=todo-be-tmp --image=todo-zulu-alpine-jre-11 --image-pull-policy=Never --port=9091 --labels="app=todo,env=prod" --generator=run-pod/v1`

- [optional] Check the status of the newly create k8s objects

    `kubectl get all --namespace=todo-be-tmp -o wide`

- [optional] clean up

    `kubectl delete all --all --namespace=todo-be-tmp`
        
    >__Notes:__
    > If image is not found on then we will get the following error STATUS: ErrImageNeverPull and READY: 0/1
    > 


### Issues:

1. How to instruct docker to use again local host configuration?

    `eval $(minikube docker-env -u)`

> Notes:
> Further information [here](https://dzone.com/articles/running-local-docker-images-in-kubernetes-1?utm_source=dzone&utm_medium=article&utm_campaign=k8s-cluster)


## Recipe 2

### __Goal__ 
__How to delete all feature related kubernetes objects in one go__

### __Solution:__ 

Probable the easiest way of achieving this is using namespaces.

### __Steps__

1. create a namespace

    `kubectl create namespace todo-be-tmp`

1. [optional] get information about all namespaces

    `kubectl get namespaces -o wide`

1. [optional] get information about a specific namespace

    `kubectl get namespaces todo-be-tmp -o yaml`

1. create and run a docker pod and attach all new k8s objects to the newly created namespace

    `kubectl run todo-be-tmp --namespace=todo-be-tmp --image=todo-zulu-alpine-jre-11 --image-pull-policy=Never --port=9091 --labels="app=todo,env=prod" --generator=run-pod/v1 --dry-run`
    
1. delete all newly created k8s objects associated with a namespace

    `kubectl delete all --all --namespace=todo-be-tmp`
 
