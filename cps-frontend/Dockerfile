FROM node:latest as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app
RUN npm install -g npm@6.14.15

RUN npm run build -- --base-href='/cps-frontend/'

FROM nginx:latest
COPY dist/cps-frontend /usr/share/nginx/html
EXPOSE 5001npm
