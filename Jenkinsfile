@Library('shared-library') _
pipeline {
    agent { label 'maven-node' }
    tools {
        maven 'MavenHome'
        jdk 'JAVAHOME'
    }
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
                helloWorld(name: 'Alice', dayOfWeek: 'Monday')
            }
        }

        stage('Build') {
            steps {
                dir('parallelTestExecutor') {
                    sh 'mvn clean install'
                }
            }
        }

    // stage('compile maven project') {
    //     steps {
    //         script {
    //             def mavenProject = 'parallelTestExecutor'
    //             def mavenGoals = 'clean install'
    //             sh "mvn -f ${mavenProject}/pom.xml ${mavenGoals}"
    //         }
    //     }
    // }
    }
}
