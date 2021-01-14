pipeline {
    agent any

    stages {
        stage('Permissions') {
          steps {
            sh 'chmod +x gradlew'
          }
        }
        stage('Build') {
          steps {
            sh './gradlew clean build'
          }
        }
        stage('Deploy') {
          steps {
            sh './gradlew clean build deployHeroku'
          }
        }
    }
}
