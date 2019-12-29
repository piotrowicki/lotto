pipeline {
    agent { dockerfile true }
    environment {
        BUILD_NUM = currentBuild.getNumber()
    }
    stages {
        stage('Preparation') {
            steps {
                git branch: 'master', url: 'https://github.com/piotrowicki/lotto.git'
            }
        }
        stage('Build') {
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
    }
}
