FROM 145696892367.dkr.ecr.us-west-2.amazonaws.com/base:node-nginx

ENV MODULE=ruoyi-ui
ARG DEPENDENCY=dist/
WORKDIR /usr/app/

RUN  mkdir -p /usr/app && cd ${WORKDIR}
COPY . ${WORKDIR}

RUN rm -rf /usr/share/nginx/html/*
#RUN npm install -g npm@8.19.2 --registry=https://registry.npm.taobao.org
RUN npm install -g npm@8.19.2
RUN npm install --legacy-peer-deps \
    && npm run build:prod

RUN mv ${WORKDIR}${DEPENDENCY}* /usr/share/nginx/html \
    && rm -rf /usr/app/*

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
