# tilt-k8s - setup local k8s env using tilt

## Install tilt

https://docs.tilt.dev/install.html

## Create a Sample app

A spring-boot application will be used which can be found in this repository

## Create a Dockerfile

A Dockerfile is needed to containerize the application. A simple Dockerfile can be:

```
FROM maven:3-jdk-11 as BUILD

COPY . /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jre-slim
ENV PORT 42050
EXPOSE 42050
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target

CMD ["/bin/bash", "-c", "find -type f -name '*.jar' | xargs java -jar"]
```

### K8s-Deployment

Kubernetes manifest file named deployment.yaml needs to be created :

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: tilt-demo
  labels:
    app: tilt-demo
spec:
  selector:
    matchLabels:
      app: tilt-demo
  template:
    metadata:
      labels:
        app: tilt-demo
    spec:
      containers:
      - name: tilt-demo
        image: snigdhasambit/tilt-demo:latest
        ports:
        - containerPort: 42050
```
## Choosing a Local Dev Cluster

There are lots of Kubernetes dev solutions out there. The choices can be overwhelming. More details can be found below:

https://docs.tilt.dev/choosing_clusters.html#microk8s

## Tiltfile

Finally, a Tiltfile file is needed similar to this:

```
docker_build('snigdhasambit/tilt-demo:latest', '.')
k8s_yaml('deployment.yaml')
k8s_resource('tilt-demo', port_forwards=42050)
```

## Application Deployment

Now you can bring the application up by using this :

```
tilt up
```

## Check the deployments

Once things are up and running we can verify the deployment:

```
$ kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
tilt-demo-7aa88cd876-xcn7j   1/1     Running   0          1m5s
```

## Destroy

```
tilt down
```
