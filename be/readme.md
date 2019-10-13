# Objectives

## Prerequisites

- java 11 installed
- maven 3.5+ installed

## Action steps:

- [x] Build and run a spring application in a docker container

    - [x] documentation about sb application in docker
        - [here](https://spring.io/guides/gs/spring-boot-docker/)
        - [here](https://spring.io/guides/topicals/spring-boot-docker)
    - [x] jdk -> [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/docker-install.html)
    - [x] jre 
        -> [Azul jre-11 alpine docker hub](https://hub.docker.com/r/azul/zulu-openjdk-alpine/tags)
        -> [Azul jre/jdk home page](https://www.azul.com/downloads/zulu-community/)

    - How to build/run/test/publish the application?
    
        - build the application 
        `mvn package`

        - build the maven image
        `docker build -t todo-zulu-alpine-jre-11 .`

        - start the container and run the application
        `docker run -d -p 8080:8080 --name todo-zulu-alpine-jre-11 todo-zulu-alpine-jre-11`

        - test the docker container is running
        `docker ps`

        - test the application
        `curl http://localhost:8080`
        
        - stop the container
        `docker container stop todo-zulu-alpine-jre-11`

        - remove the container
        `docker container rm todo-zulu-alpine-jre-11`
       
        - check if it was successfully removed
        `docker container ps -a | grep -i todo-zulu-alpine-jre-11 --color=always`
        
        - publish the image
        ```bash
        docker login
        # publish latest version
        docker tag todo-zulu-alpine-jre-11 jtonic/todo-zulu-alpine-jre-11
        docker push jtonic/todo-zulu-alpine-jre-11
        # latest version taged as v1
        docker tag todo-zulu-alpine-jre-11 jtonic/todo-zulu-alpine-jre-11:v1
        docker push jtonic/todo-zulu-alpine-jre-11:v1
        ```
      
        - [x] create the kubernetes deployment/service for the backend.
        
        See the file `./k8s/todo-be-service-deployment.yaml`
        
        > Initially we will expose the service publicly by using the `spec:type: NodePort` 
        > later on, when we'll have a frontend, the fe will be of type of NodePort and be of type `ClusterIP`  

        - [x] deploy and run the BE in the minikube cluster
        
        `kubectl create -f ./k8s/todo-be-service-deployment.yaml`
        
        - [x] call the REST endpoint using the default browser
        
        `minikube service todo-be`
        
        - [x] or run curl `curl  $(minikube service todo-be --url)` 
        
        > **Note** If something went wrong, and the mistakes is in the kubernetes service/deployment definition file, correct the mistake and replace/redeploy it.
        > The command: `kubectl replace --force -f ./k8s/todo-be-service-deployment.yaml`. DON'T USE THIS IN PROD!!!

        - **Clean up**
        
        - show running container
        `docker ps`
        
        - stop container 
        `docker stop todo-zulu-alpine-jre-11`
        
        - remove container 
        `docker rm todo-zulu-alpine-jre-11`
        
        - remove the tagged images
        ```bash
        docker image rm todo-zulu-alpine-jre-11
        docker image rm jtonic/todo-zulu-alpine-jre-11
        docker image rm jtonic/todo-zulu-alpine-jre-11:v1
        ``` 
        - stop minikube `minikube stop`
        
        - removed unused images
        `docker image prune`
        
        - run the remote docker image (for production it is mandatory to run a version)
        `docker run -d -p 8080:8080 --name todo-zulu-alpine-jre-11 jtonic/todo-zulu-alpine-jre-11:v1`
        
        - test the application again (see above)
        
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
    - [ ] a springboot microservice - type ClusterIP (internal IP)
    - [ ] a vuejs frontent application (calling the backend endpoints) - type NodePort (external fix IP)
- [ ] Same as above but deployed to AWS cluster     
    
- [ ] inheritable ThreadLocal when a new child thread is created from http servlet request thread. 

## Temporarily action items
    - detach the springboot-docker from the VCS
    - delete the repository from github Tony
    - create a new directory - todo
    - move springboot-docker inside todo
    - rename springboot-docker to fe
    - push todo directory in github
    - create a fe directory undee

    - FE (Vue.js, VueX, Vue router, Vue-RX, Axios, Quasar)
        - TBD

## __Notes:__

- use `kubectl get ` command with `-o wide` option to see further information 
