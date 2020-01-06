pipeline {
    agent any
    environment {
        IMAGE_NAME = 'tomee-image'
        CONTAINER_NAME = 'tomee'
    }
    stages {
        stage('Preparation') {
            steps {
                git branch: 'master', url: 'https://github.com/piotrowicki/lotto.git'
            }
        }
        stage('Build & test') {
            tools { 
               maven 'Maven 3.6.3'
            }
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true -Dversion="$BUILD_TIMESTAMP" clean package' 
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