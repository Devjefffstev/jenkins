pipeline {
    agent any
    stages {
        stage('Check Groovy Version') {
            steps {
                withGroovy {
                    sh 'groovy --version'
                }
            }
        }
    }
}
