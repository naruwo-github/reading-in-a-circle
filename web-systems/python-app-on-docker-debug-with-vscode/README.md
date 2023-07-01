# Python Web Application

This repository contains a Python web application configured to run inside a Docker container. The application is set to be deployed with Gunicorn and uWSGI.

## Project Structure

- `/app`: The main application folder containing the Python code.
- `docker-compose.yaml`: A file to define and run multiple Docker applications.
- `.devcontainer/devcontainer.json`: A configuration file to run the application inside a Docker container using the development container functionality of Visual Studio Code.

## Prerequisites

- Docker
- Python 3.8
- Gunicorn
- uWSGI

## Setup

1. Clone the repository.
2. Build the Docker images: `docker-compose build`
3. Start the Docker containers: `docker-compose up`

## Using the Application

After starting the Docker containers, you can access the application on port 5001.

## Debugging

This application is configured to be debugged using Visual Studio Code. The configuration for this is located in `.devcontainer/devcontainer.json`.

To debug the application:

1. Open the project in Visual Studio Code.
2. Go to the Run view (Ctrl+Shift+D).
3. Select the appropriate configuration from the dropdown in the Run view. In this case, it should be the one specified in your `launch.json` file.
4. Press F5 or click the green arrow to start debugging.

This will launch the application within the DevContainer with the debugger attached, allowing you to set breakpoints, step through the code, and inspect variables.
