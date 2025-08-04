pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo/shopping-app.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('My SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t shopping-app:latest .'
            }
        }
    }
}