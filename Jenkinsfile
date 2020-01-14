pipeline {
    agent any
    environment {
        IMAGE_NAME = 'tomee-image'
        CONTAINER_NAME = 'tomee'
    }
    stages {
        stage('Preparation') {
            steps {
                git branch: 'prod', url: 'https://github.com/piotrowicki/lotto.git'
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
        stage('Build container') {
            steps {
                sh 'docker rm -f ${CONTAINER_NAME} || true && docker run -d -p 8080:8080 --network="docker_app-tier" --restart always --name ${CONTAINER_NAME} ${IMAGE_NAME}'
            }
        }
        stage('Deploy') {
            steps {
                timeout(5) {
                    waitUntil {
                        script {
                            def r = sh script: 'wget -q http://tomee:8080 -O /dev/null', returnStatus: true
                            return (r == 0);
                        }
                    }
                }
                deploy adapters: [tomcat8(credentialsId: 'tomee-deployer', url: 'http://tomee:8080')], contextPath: 'lotto', onFailure: false, war: '**/*.war'         
            }
        }
    }
}
