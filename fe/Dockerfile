FROM node:lts-alpine AS builder-stage
COPY ./ /app
WORKDIR /app
RUN npm install && npm run build

FROM nginx:stable-alpine as production-stage
RUN mkdir /app
COPY --from=builder-stage /app/dist /app
COPY nginx.conf /etc/nginx/nginx.conf
