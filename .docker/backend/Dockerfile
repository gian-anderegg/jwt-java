FROM maven:3-openjdk-17
#RUN uname -r
#CMD exec /bin/bash -c "trap : TERM INT; sleep infinity & wait"
WORKDIR /app
COPY ./backend .
#RUN apt-get install watchexec
RUN mvn install
RUN mvn clean install

ENTRYPOINT java -jar target/*.jar