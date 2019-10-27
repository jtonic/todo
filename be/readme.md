# Objectives

## Prerequisites

- java 11 installed
- maven 3.5+ installed

## Action steps

- [x] Build and run a spring application in a docker container

  - [x] documentation about sb application in docker
    - [here](https://spring.io/guides/gs/spring-boot-docker/)
    - [here](https://spring.io/guides/topicals/spring-boot-docker)
  - [x] jdk -> [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/docker-install.html)
  - [x] jre
    - [Azul jre-11 alpine docker hub](https://hub.docker.com/r/azul/zulu-openjdk-alpine/tags)
    - [Azul jre/jdk home page](https://www.azul.com/downloads/zulu-community/)

  - How to build/run/test/publish the application?

    - use the minikube docker to build the image
    `eval $(minikube docker-env)`

    - build the maven image
    `docker build -t todo-zulu-alpine-jre-11 -f ./be/Dockerfile ./be`

    > __Notes:__
    > in order to simplify the local development and not publishing every build in docker hub/registry:
    > - Make the kubectl virtual machine's docker the current one (instead of the host docker) `eval $(minikube docker-env)`
    > - Don't version every build by tagging it
    > - To make the host docker again the current one use `eval $(minikube docker-env -u)`

    - [optional-1] start the container and run the application
    `docker run -d -p 8081:8081 --name todo-zulu-alpine-jre-11 todo-zulu-alpine-jre-11`

    - [optional-1] test the docker container is running
    `docker ps`

    - [optional-2] test the application
    `curl http://localhost:8081`

    - [optional-1] stop the container
    `docker container stop todo-zulu-alpine-jre-11`

    - [optional-1] remove the container
    `docker container rm todo-zulu-alpine-jre-11`

    - [optional-1] check if it was successfully removed
    `docker container ps -a | grep -i todo-zulu-alpine-jre-11 --color=always`

    - [optional-1] publish the image
    ```bash
    docker login
    # publish latest version
    docker tag todo-zulu-alpine-jre-11 jtonic/todo-zulu-alpine-jre-11
    docker push jtonic/todo-zulu-alpine-jre-11
    # latest version taged as v1
    docker tag todo-zulu-alpine-jre-11 jtonic/todo-zulu-alpine-jre-11:v1
    docker push jtonic/todo-zulu-alpine-jre-11:v1
    ```

    - [x] create k8s namespace

    `kubectl create -f ../k8s/todo-namespace.yaml`

    - [x] and the check the new namespace

    `kubectl get ns`

    - [x] create the kubernetes deployment/service for the backend.

    See the files in folder `./k8s`

    > Initially we will expose the service publicly by using the `spec:type: NodePort`
    > later on, when we'll have a frontend, the fe will be of type of NodePort and be of type `ClusterIP`

    - [x] __deploy and run the BE in the minikube cluster__

    `kubectl create -f ./k8s`

    - [x] port-forward from host to k8s service

    `kubectl port-forward svc/todo-be -n todo 9092:8081`

    - [x] and test with curl

    `curl -X GET http://localhost:9092/`

    - [optional-2] [x] in case the be service is exposed on public ip:port run the following curl

    `curl  $(minikube service todo-be --url)`

    > **Note** If something went wrong, and the mistakes is in the kubernetes service/deployment definition file, correct the mistake and replace/redeploy it.
    > The command: `kubectl replace --force -f ./k8s/todo-be-service-deployment.yaml`. DON'T USE THIS IN PROD!!!

    - **Clean up**

    - delete all k8s objects in namespace todo

    `kubectl delete all --all -n todo`

    - check to see if all have been removed

    `kubectl get all -n todo`

    - delete the newly created docker images

    `docker rmi todo-zulu-alpine-jre-11:latest`

    - setup the host docker daemon as the current one

    `eval $(minikube docker-env -u)`

    - stop minikube `minikube stop`

    > **Note:** As a piece of advice consider making a small image.
    >
    > The image size can be queried with the following command:
    >
    >  `docker images jtonic/todo-zulu-alpine-jre-11:v1  --format "{{.Repository}}:{{.Tag}} {{.Size}}"`
    >
    > with zool jre 11
    >  docker images todo-zulu-alpine-jre-11  --format "{{.Repository}}:{{.Tag}} {{.Size}}"
    >  todo-zulu-alpine-jre-11:latest **151MB**
    >
    > with amazon corretto jdk 11
    > docker images jtonic/springboot-docker:v1  --format "{{.Repository}}:{{.Tag}} {{.Size}}"                                                                     master ✱
    > jtonic/springboot-docker:v1 **514MB**
    >
    > As you can see there is a huge difference 151 MB -> 514 MB

- [x] incremental migration from junit4 to junit5 (kotlin project included)
- [x] junit tests with custom logger level
- [x] spring boot 2 with custom logger level
  - The log level can be changed per springboot test class with

  ```java
  @SpringBootTest(properties = {"logging.level.ro.jtonic.apps.todo=ERROR"})
  @ExtendWith(SpringExtension.class)
  @ComponentTag
  class TodoApplicationTest {  }
  ```

- [x] (simple) use MapStruct for object mapping (for advanced usage see baeldung tutorials below):
  - See why:
    - [performance comparison](https://www.baeldung.com/java-performance-mapping-frameworks
)
    - [Using multiple source usage, update the target](https://www.baeldung.com/mapstruct-multiple-source-objects)
    - works perfectly with Lombok
    - its not based on reflection
    - allows multiple sources
    - allows target update
    - easy integration with CDI (spring)
  - [Quick guide](https://www.baeldung.com/mapstruct)
  - [Official documentation](https://mapstruct.org/documentation/stable/reference/html/#introduction)
  - [Simple example with mapstruct/lombok/docker](https://hellokoding.com/mapping-jpa-hibernate-entity-and-dto-with-mapstruct/)

- [ ] Deploy to Minikube via kubectl
  - [x] a springboot microservice - type ClusterIP (internal IP)
  - [ ] a vuejs frontent application (calling the backend endpoints) - type NodePort (external fix IP)
- [ ] Same as above but deployed to AWS cluster

- [ ] inheritable ThreadLocal when a new child thread is created from http servlet request thread.

## __Notes:__

- use `kubectl get` command with `-o wide` option to see further information

## Optionals explanations

- __optional-1__
  - when:
    - local development
    - minikube's docker daemon is used
    - Dockerfile is multistage:
      - stage 1 (build) build the project with mvn package
      - stage 2 (prod) run the java/sb application with artifacts produced by stage build.

- __optional-2__
  - when: be services are exposed externally using the `type: NodePort`

## Best practices

- [k8 best practices](../docs/best_practices/k8s-bp.md)

- [docker best practices](../docs/best_practices/docker-bp.md)
