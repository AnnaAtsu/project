pipeline {
    agent any

    tools {
        maven 'M3'      // Имя инструмента Maven из настроек Jenkins → Global Tool Configuration
        jdk 'JDK17'     // Имя JDK из настроек Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Allure Report') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }

    post {
        always {
            // Опционально: архивировать результаты
            archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
        }
    }
}