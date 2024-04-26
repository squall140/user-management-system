#!/usr/bin/env bash

curPath=$(readlink -f "$(dirname "$0")")
prjConfig=/home/ec2-user/biease/config/biease-api

cd $curPath

# customize configuration in yaml
sed -i "s#__IMAGE__#$1#g" docker-compose.yml
sed -i "s#__HOST_IP__#$2#g" docker-compose.yml

#sed -i "s#__HOST_IP__#$2#g" resources/application-deploy.yml
#sed -i "s#__REDIS__#$2#g" resources/application-deploy.yml

# setting the config-files home
mkdir -p ${prjConfig}/
rm -rf ${prjConfig}/*
cp -rf resources/* ${prjConfig}/


# pull up ...
sleep 5
docker-compose up -d