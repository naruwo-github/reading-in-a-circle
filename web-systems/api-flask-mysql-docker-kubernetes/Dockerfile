FROM python:3.9-slim

WORKDIR /app

# wait for db server activated
COPY ./wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

COPY requirements.txt requirements.txt
RUN apt-get update && \
    apt-get install -y default-libmysqlclient-dev gcc && \
    pip install --trusted-host pypi.python.org -r requirements.txt

COPY . .

CMD ["/wait-for-it.sh", "${DB_HOST}:3306", "--", "python", "app.py"]