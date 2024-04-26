FROM adoptopenjdk/openjdk11:jre-11.0.23_7-ea-beta-ubuntu-nightly

ENV MODULE=ums-api
ENV VERSION=1.0.0
ENV PORT=8999
ENV WORKDIR=/java-build/
ARG DEPENDENCY=${MODULE}/target
ENV JAVA_OPTS=""

COPY . ${WORKDIR}
WORKDIR ${WORKDIR}

# RUN mvn clean package  -Dmaven.test.skip=true
WORKDIR /app
RUN mv  ${WORKDIR}${DEPENDENCY}/${MODULE}-${VERSION}-exec.jar /app/${MODULE}.jar
COPY ./entrypoint.sh /app
RUN chmod +x /app/entrypoint.sh
RUN rm -rf /${WORKDIR}

RUN mkdir -p /app/temp
RUN mkdir -p /app/logs

RUN chmod 777 -R /app/temp
RUN chmod 777 -R /app/logs

EXPOSE 8999 25
ENTRYPOINT ["./entrypoint.sh"]
