def call(String Project, String ImageTag, String dockerhubuser) {
  withCredentials([usernamePassword(credentialsId: 'DockerConfig', passwordVariable: 'DockerConfigpass', usernameVariable: 'DockerConfigUser')]) {
      sh " docker login -u ${dockerhubuser} -p ${DockerConfigpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}" // Push the image
  echo "project push"
}
