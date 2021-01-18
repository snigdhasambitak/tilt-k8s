docker_build('snigdhasambit/tilt-demo:latest', '.')
k8s_yaml('deployment.yaml')
k8s_resource('tilt-demo', port_forwards=42050)
allow_k8s_contexts(['my-staging-cluster', 'gke_some-project-123456_us-central1-b_windmill'])
