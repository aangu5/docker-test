pipeline {
    agent { dockerfile true }
    triggers {
        pollSCM '*/10 * * * *'
    }
    stages {
        stage('Validate') {
            steps {
                sh 'mvn validate'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Verify') {
            steps {
                sh 'mvn verify'
            }
        }
        stage('Install') {
            steps {
                sh 'mvn install'
            }
        }
        stage('Docker') {
            agent {
                docker { image 'openjdk:15-jdk-alpine'}
            }
            steps {
                sh 'mvn --version'
            }
        }
    }
}