minikube start

minikube dashboard

attention: keep secret in production!
kubectl create secret generic db-root-pass --from-literal=password=root

kubectl apply -f k8s/k8s-configmap.yaml
kubectl apply -f k8s/db-deployment.yaml
kubectl apply -f k8s/db-service.yaml
kubectl apply -f k8s/app-deployment.yaml
kubectl apply -f k8s/app-service.yaml
