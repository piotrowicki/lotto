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
                git branch: 'prod', url: 'https://github.com/piotrowicki/lotto.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean package' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: 
                    tomcat7([credentialsId: '453c067c-6c6d-4075-9116-0b8364e47783', url: 'http://54.37.136.83:8080/']), 
                    contextPath: 'lotto', 
                    onFailure: false, 
                    war: '**/*.war'
            }
        }
    }
}
