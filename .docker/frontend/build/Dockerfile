FROM node:15.13.0

WORKDIR /app

COPY ./vue-client .

RUN npm install

#CMD exec /bin/bash -c "trap : TERM INT; sleep infinity & wait"
CMD npm run serve