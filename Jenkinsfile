pipeline {
    agent any
    environment {
        IMAGE_NAME = 'lotto-image'
        CONTAINER_NAME = 'lotto'
    }
    stages {
        stage('Preparation') {
            steps {
                git branch: 'master', url: 'https://github.com/piotrowicki/lotto.git'
            }
        }
        stage('Build application') {
            tools { 
               maven 'Maven 3.6.3'
            }
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean package' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        stage('Build image') {
            steps {
                sh 'docker build -t ${IMAGE_NAME} .'
            }
        }      
    }
}