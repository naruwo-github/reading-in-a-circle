### How to activate this cluster

activate minikube

```bash
minikube start
minikube dashboard
```

create secret info
**attention** keep secret in production!

```bash
kubectl create secret generic db-root-pass --from-literal=password=root
```

apply settings

```bash
kubectl apply -f k8s/k8s-configmap.yaml
kubectl apply -f k8s/db-deployment.yaml
kubectl apply -f k8s/db-service.yaml
kubectl apply -f k8s/app-deployment.yaml
kubectl apply -f k8s/app-service.yaml
```

port forwarding

```bash
minikube tunnel
```

```bash
# post
curl -X POST -H "Content-Type: application/json" -d '{"name":"John Doe"}' http://localhost:5001/users

# get
curl http://localhost:5001/users/1

# ...
```
