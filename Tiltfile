docker_build('roukou/tilt-demo', '.')
k8s_yaml('deployment.yaml')
k8s_resource('tilt-demo', port_forwards=42050)
allow_k8s_contexts('gke_lbn-compute-dev-97d248_asia-southeast1-a_lbn-dev-alpha')
