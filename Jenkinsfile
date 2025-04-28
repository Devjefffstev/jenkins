pipeline {
    agent { label 'linux' }
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
