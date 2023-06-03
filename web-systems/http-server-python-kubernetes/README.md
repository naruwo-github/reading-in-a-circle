# How to start this k8s cluster(on local)

## Prerequisites

Ensure you have the following installed on your local machine:

- Docker: For building and storing your application's container images.
- Minikube: To run your Kubernetes cluster locally.
- kubectl: To interact with your Kubernetes cluster.

## Steps

1. **Build Docker image**

   First, build your Docker image locally with the Dockerfile provided. Replace `<your-image-name>` with the name of your Docker image.

   ```bash
   eval $(minikube docker-env)
   docker build -t <your-image-name>:<tag-name> .
   # Default image name is `http-service-python-kubernetes`, and Default tag name is `3.8`.
   ```

   Ensure that your Docker image is listed with the following command:

   ```bash
   docker images
   ```

2. **Create and apply Kubernetes Deployment**

   Make sure that the image name in the `deployment.yaml` file matches the name of your Docker image.

   Then apply the Deployment with:

   ```bash
   kubectl apply -f deployment.yaml
   ```

3. **Create and apply Kubernetes Service**

   Like the Deployment, make sure that the label in the `service.yaml` file matches that in your Deployment.

   Then apply the Service with:

   ```bash
   kubectl apply -f service.yaml
   ```

4. **Access the application**

   Once your Service is running, get the URL of your application with:

   ```bash
   minikube service <your-service-name> --url
   # Default service name is `http-server-service`.
   ```

   Open this URL in a web browser to view your application.

## Helpful commands

- View the status of your deployed resources:

  ```bash
  kubectl get all
  ```

- View logs for a specific pod:

  ```bash
  kubectl logs <pod-name>
  ```

- Delete a specific resource:

  ```bash
  kubectl delete -f <file.yaml>
  ```

- Delete all resources:

  ```bash
  kubectl delete all --all
  ```

Enjoy running your application on Kubernetes!
