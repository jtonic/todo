# todo-fe

## Project setup

```
npm install
```

### Compiles and hot-reloads for development

```
npm run serve
```

### Compiles and minifies for production

```
npm run build
```

### Run your tests

```
npm run test
```

### Lints and fixes files

```
npm run lint
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).

### Deployment of vue.js application with docker/ngnix

- build the image

```
docker build -t my-vuejs-app .
```

- run the container for the image

```
docker run -d -p 8080:80 my-vuejs-app

```

- publish image to docker hub

```
docker login
docker tag my-vuejs-app jtonic/my-vuejs-app:v1
docker push jtonic/my-vuejs-app:v1
```
