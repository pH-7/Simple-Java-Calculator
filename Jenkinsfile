pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/pH-7/Simple-Java-Calculator.git'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh './mvnw clean install'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw package'
            }
        }
    }
}
