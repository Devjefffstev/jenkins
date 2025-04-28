pipeline {
    agent any
    stages {
        stage('Check Groovy Version') {
            steps {
                script {
                    def groovyVersion = sh(script: 'groovy --version', returnStdout: true).trim()
                    echo "Groovy Version: ${groovyVersion}"
                }
            }
        }
    }
}
