FROM node:18-slim
WORKDIR /usr/src/app
COPY ./app/package*.json ./
RUN npm install
CMD ["npm", "start"]