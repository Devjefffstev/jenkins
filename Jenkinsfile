@Library('shared-library') _
pipeline {
    agent { label 'maven-node' }
    tools {
        maven 'MavenHome'
        jdk 'JAVAHOME'
    }
    stages {
        // stage('Check Linux Version') {
        //     steps {
        //         script {
        //             def linuxVersion = sh(script: 'cat /etc/os-release', returnStdout: true).trim()
        //             echo "Linux Version: ${linuxVersion}"
        //         }
        //     }
        // }
        // stage('clojure') {
        //     steps {
        //         echo 'Clojure version: Hola'
        //     }
        // }
        // stage('using libraries') {
        //     steps {
        //         helloWorld(name: 'Alice', dayOfWeek: 'Monday')
        //     }
        // }
        // stage('Build parallelProject') {
        //     steps {
        //         dir('parallelTestExecutor') {
        //             sh 'mvn clean install'
        //         }
        //     }
        // }
        // stage('Test parallelProject') {
        //     steps {
        //         dir('parallelTestExecutor') {
        //             sh 'mvn test'
        //         }
        //     }
        // }
        // stage('Clone Calculator project') {
        //     steps {
        //             git url: 'https://github.com/Ratnakar14/CalculatorWithSpringBoot.git', branch: 'main'
        //     }
        // }
        // stage('Build Calculator project') {
        //     steps {
        //         dir('calculater/calculater/ASL Coding Test') {
        //             sh 'mvn clean install'
        //         }
        //     }
        // }
        // stage('Test Calculator project') {
        //     steps {
        //         dir('calculater/calculater/ASL Coding Test') {
        //             sh 'mvn test'
        //         }
        //     }
        // }
        stage('Build and Test') {
            steps {
                dir('CalculatorWithSpringBoot') {
                    sh 'mvn clean install'
                    sh 'mvn test'
                }
            }
        }
    }
}
