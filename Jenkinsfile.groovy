node{
    pipeline {
        agent any
        options {
            buildDiscarder(logRotator(numToKeepStr: '5'))
        }
        environment {
            DOCKERHUB_CREDENTIALS = credentials('dockerhub')
        }
        stages {
            stage('Build') {
                steps {
                    sh 'docker build -t abubakar243/jenkins-docker-hub .'
                }
            }
            stage('Login') {
                steps {
                    withCredentials([string(credentialsId: 'dockerPassword', variable: 'dockerPassword')])

                            {
                                sh ' docker login -u abubakar243 -p ${dockerPassword}'
                            }

                }
            }
            stage('Push') {
                steps {
                    sh 'docker push abubakar243/jenkins-docker-hub'
                }
            }
        }
        post {
            always {
                sh 'docker logout'
            }
        }
    }

}