FROM node:lts-alpine AS build
COPY ./ /app
WORKDIR /app
RUN npm install
RUN npm run build

FROM nginx:stable-alpine as prod
RUN mkdir /app
COPY --from=build /app/dist /app
COPY nginx.conf /etc/nginx/nginx.conf
