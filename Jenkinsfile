pipeline {
    agent any
    stages {
        stage('Check Linux Version') {
            steps {
                script {
                    def linuxVersion = sh(script: 'cat /etc/os-release', returnStdout: true).trim()
                    echo "Linux Version: ${linuxVersion}"
                }
            }
        }
    }
}
