minikube start

minikube dashboard

attention: keep secret in production!
kubectl create secret generic db-root-pass --from-literal=password=root

kubectl apply -f k8s-configmap.yaml
kubectl apply -f app-deployment.yaml
kubectl apply -f app-service.yaml
kubectl apply -f db-deployment.yaml
kubectl apply -f db-service.yaml
