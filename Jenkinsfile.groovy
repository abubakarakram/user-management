
    pipeline {
        agent any
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

            stage('logout')
                    {
                        steps{
                            sh 'docker logout'
                        }
                    }
        }



}