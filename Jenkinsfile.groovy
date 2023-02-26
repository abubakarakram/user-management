pipeline {
    agent any
    tools{
       maven 'maven-9'
    }

    stages {
        stage('checkout') {
            steps {

                checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-access-token', url: 'https://github.com/abubakarakram/user-management.git']]])
                bat 'mvn clean package'
                bat 'echo ${env.BRANCH_NAME}'
            }
        }
        stage('Build') {
            steps {
                bat 'docker build -t abubakar243/user-management .'
            }
        }
        stage('Login') {
            steps {
                withCredentials([string(credentialsId: 'passwordId', variable: 'dockerPassword')]) {


                        bat 'type ${dockerPassword} | docker login -u abubakar243 --password-stdin'


                }
            }
        }
        stage('Push') {
            steps {
                bat 'docker tag abubakar243/user-management:latest abubakar243/jenkins-docker-hub:latest'
                bat 'docker push abubakar243/jenkins-docker-hub:latest'
            }
        }


    }


}