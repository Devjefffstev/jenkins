#!groovy
// @Library('shared-library') _
// pipeline {
//     agent { label 'maven-node' }
//     tools {
//         maven 'MavenHome'
//         jdk 'JAVAHOME'
//     }
//     stages {
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
//         stage('Build CalculatorWithTest project') {
//             steps {
//                 dir('CalculatorWithTest') {
//                     sh 'mvn clean install -DskipTests'
//                 }
//             }
//         }
//         stage('Test CalculatorWithTest project') {
//             steps {
//                 dir('CalculatorWithTest') {
//                     sh 'mvn test'
//                 }
//             }
//         }
//     }
// }

node('maven-node') {
    // Define tools
    def mvnHome = tool name: 'MavenHome', type: 'maven'
    def jdkHome = tool name: 'JAVAHOME', type: 'jdk'

    // Set environment variables
    env.PATH = "${jdkHome}/bin:${mvnHome}/bin:${env.PATH}"
    // Capture the start time
    def startTime = System.currentTimeMillis()
    echo "Pipeline started at: ${new Date(startTime)}"
    stage('check folder') {
        sh 'ls -l'
        echo "Pipeline started at: ${new Date(startTime)}"
    }
    stage('clone repo') {
        // Clone the repository
        git url: 'https://github.com/Devjefffstev/jenkins.git', branch: 'main'
    }
    stage('Build CalculatorWithTest project') {
        dir('CalculatorWithTest') {
            sh 'mvn clean install -DskipTests'
        }
    }

    stage('Test CalculatorWithTest project') {
        dir('CalculatorWithTest') {
            sh 'mvn install -Dmaven.test.failure.ignore=true'
        }
    }
    // Capture the end time
    def endTime = System.currentTimeMillis()
    echo "Pipeline ended at: ${new Date(endTime)}"

    // Calculate and display the total duration
    def durationInMinutes = (endTime - startTime) / (1000 * 60)
    def durationInSeconds = (endTime - startTime) / 1000
    echo "Total Pipeline Duration: ${durationInMinutes} minutes"

    stage('Clean Workspace') {
            // Clean the workspace after the build and test stages
            sh 'rm -rf *'
        echo "Total Pipeline Duration: ${durationInMinutes} minutes"
        echo "Total Pipeline Duration: ${durationInSeconds} seconds"
    }
}
