# How to start this k8s cluster(on local)

## Prerequisites

Ensure you have the following installed on your local machine:

- Docker: For building and storing your application's container images.
- Minikube: To run your Kubernetes cluster locally.
- kubectl: To interact with your Kubernetes cluster.

Activate Minikube:

```bash
minikube start
minikube dashboard # If needed
```

## Steps

0. **TL;DR**

   ```bash
   eval $(minikube docker-env)
   docker build -t http-service-python-kubernetes:3.8 -f ./Dockerfile-python38 .
   docker build -t http-service-python-kubernetes:3.11 -f ./Dockerfile-python311 .

   kubectl apply -f deployment-python38.yaml
   kubectl apply -f service-python38.yaml
   kubectl apply -f deployment-python311.yaml
   kubectl apply -f service-python311.yaml
   kubectl apply -f ingress.yaml

   minikube tunnel
   ```

1. **Build Docker image**

   First, build your Docker image locally with the Dockerfile provided. Replace `<your-image-name>` with the name of your Docker image.

   ```bash
   docker build -t <your-image-name>:<tag-name> -f ./<docker-file-name> .
   # Default image name is `http-service-python-kubernetes`, default tag name is `3.8` and default file name is `Dockerfile-python38`.
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

4. **Create and apply Kubernetes Ingress**

   Make sure that the labels in the `ingress.yaml` file match those in your Service.

   Then apply the Ingress with:

   ```bash
   kubectl apply -f ingress.yaml
   ```

5. **Access the application**

   ```bash
   minikube tunnel
   ```

   - python3.8 container: http://k8s-practice-domain.com/v38
   - python3.11 container: http://k8s-practice-domain.com/v311

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
