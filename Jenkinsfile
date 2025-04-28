@Library('shared-library') _
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
        stage('clojure') {
            steps {
                echo 'Clojure version: Hola'
            }
        }
        stage('using libraries') {
            steps {
                helloWorld(name: "Alice", dayOfWeek: "Monday")
            }
        }
    }
}
