pipeline {
    agent any
    environment {
        BUILD_NUM = currentBuild.getNumber()
    }
    tools { 
        maven 'Maven 3.6.3'
    }
    stages {
        stage('Preparation') {
            steps {
                git branch: 'master', url: 'https://github.com/piotrowicki/lotto.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
