def call(String Project, String ImageTag, String dockerhubuser) {
  withCredentials([usernamePassword(credentialsId: 'DockerConfig', passwordVariable: 'DockerConfigpass', usernameVariable: 'DockerConfigUser')]) {
      sh '''
        set -x
        docker login -u ${dockerhubuser} -p ${DockerConfigpass}
        set +x
      '''
  }
  sh "docker images | grep ${dockerhubuser}/${Project}:${ImageTag}" // Verify the image exists
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}" // Push the image
}
