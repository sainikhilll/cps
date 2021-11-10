FROM node:latest as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app
RUN npm install
RUN npm install bootstrap

RUN npm run build -- --base-href='/cps-frontend/'

FROM nginx:latest
COPY dist/cps-frontend /usr/share/nginx/html
EXPOSE 5001
