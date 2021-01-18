docker_build('snigdhasambit/tilt-demo:latest', '.')
k8s_yaml('deployment.yaml')
k8s_resource('tilt-demo', port_forwards=42050)
