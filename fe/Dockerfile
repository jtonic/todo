FROM node:lts-alpine AS build
COPY ./ /app
WORKDIR /app
RUN npm install
RUN npm run build

FROM nginx:stable-alpine as prod
RUN mkdir /app
RUN addgroup -S todofe && adduser -S todofe -G todofe
RUN chown -R todofe:todofe /app
RUN chmod 755 /app
USER todofe
COPY --from=build /app/dist /app
COPY nginx.conf /etc/nginx/nginx.conf
