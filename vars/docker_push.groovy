def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'DockerConfig', passwordVariable: 'DockerConfigpass', usernameVariable: 'DockerConfigUser')]) {
      sh "docker login -u ${DockerConfigUser} -p ${DockerConfigpass}"
  }
  sh "docker push ${DockerConfigUser}/${Project}:${ImageTag}"
}
