FROM python:3.8-slim-buster

WORKDIR /app

COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt



# Creates a non-root user and adds permission to access the /app folder
RUN adduser --disabled-password --gecos "" appuser

RUN chown -R appuser /app

# Switches to the non-root user
USER appuser

