docker_build('roukou/tilt-demo', '.')
k8s_yaml('deployment.yaml')
k8s_resource('tilt-demo', port_forwards=42050)
