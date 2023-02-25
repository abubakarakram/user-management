
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    bat 'docker build -t abubakar243/jenkins-docker-hub .'
                }
            }
            stage('Login') {
                steps {
                    withCredentials([string(credentialsId: 'dockerPassword', variable: 'dockerPassword')])

                            {
                                bat 'docker login -u abubakar243 -p ${dockerPassword}'
                            }

                }
            }
            stage('Push') {
                steps {
                    bat 'docker push abubakar243/jenkins-docker-hub'
                }
            }


        }



}