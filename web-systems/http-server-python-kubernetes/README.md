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
eval $(minikube docker-env)
```

## Steps

0. **TL;DR**

   ```bash
   kubectl apply -f deployment-python38.yaml
   kubectl apply -f service-python38.yaml
   kubectl apply -f deployment-python311.yaml
   kubectl apply -f service-python311.yaml
   kubectl apply -f ingress.yaml
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

   Once your Ingress is running, find out the Minikube cluster IP address with:

   ```bash
   minikube ip
   ```

   Use this IP address to access your application through the Ingress. Remember to use the host you specified in the Ingress configuration. If you are using `curl`, you can set the host with the `-H` option:

   ```bash
   curl -H "Host: k8s-practice-domain.com" http://<minikube-ip>
   ```

   Replace `k8s-practice-domain.com` with the host you specified in the Ingress configuration.

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
