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

// node('maven-node') {
//     // Define tools
//     def mvnHome = tool name: 'MavenHome', type: 'maven'
//     def jdkHome = tool name: 'JAVAHOME', type: 'jdk'

//     // Set environment variables
//     env.PATH = "${jdkHome}/bin:${mvnHome}/bin:${env.PATH}"
//     stage('clone repo') {
//         // Clone the repository
//         git url: 'https://github.com/Devjefffstev/jenkins.git', branch: 'main'
//     }
//     stage('Build CalculatorWithTest project') {
//         dir('CalculatorWithTest') {
//             sh 'mvn clean install -DskipTests'
//         }
//     }

//     stage('Test CalculatorWithTest project') {
//         dir('CalculatorWithTest') {
//             sh 'mvn test'
//         }
//     }
//     stage('testwithFunction') {
//         dir('CalculatorWithTest') {
//             // Call the function to run tests
//             runTests()
//         }
//     }

//     stage('Clean Workspace') {
//             // Clean the workspace after the build and test stages
//             sh 'rm -rf *'
//     }
// }

// void runTests(def args) {
//     mvn 'install -Dmaven.test.failure.ignore=true'
//     /* Archive the test results */
//     junit '**/target/surefire-reports/TEST-*.xml'
// }




/* Only keep the 10 most recent builds. */
properties([[$class: 'BuildDiscarderProperty',
                strategy: [$class: 'LogRotator', numToKeepStr: '10']]])

node {
  stage 'Checkout'
  checkout scm

  stage 'Build'

  /* Call the maven build. */
  mvn "clean install -B -V -U -e -Dsurefire.useFile=false -Dmaven.test.failure.ignore=true"

  /* Save Results. */
  stage 'Results'

  /* Archive the test results */
  step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

  /* Archive the build artifacts */
  step([$class: 'ArtifactArchiver', artifacts: 'target/*.hpi,target/*.jpi'])
}

/* Run maven from tool "mvn" */
void mvn(def args) {
  /* Get jdk tool. */
  String jdktool = tool name: "jdk7", type: 'hudson.model.JDK'

  /* Get the maven tool. */
  def mvnHome = tool name: 'mvn'

  /* Set JAVA_HOME, and special PATH variables. */
  List javaEnv = [
    "PATH+JDK=${jdktool}/bin", "JAVA_HOME=${jdktool}",
    // Additional variables needed by tests on machines
    // that don't have global git user.name and user.email configured.
    'GIT_COMMITTER_EMAIL=me@hatescake.com','GIT_COMMITTER_NAME=Hates','GIT_AUTHOR_NAME=Cake','GIT_AUTHOR_EMAIL=hates@cake.com', 'LOGNAME=hatescake'
  ]

  /* Call maven tool with java envVars. */
  withEnv(javaEnv) {
    if (isUnix()) {
      sh "${mvnHome}/bin/mvn ${args}"
    } else {
      bat "${mvnHome}\\bin\\mvn ${args}"
    }
  }
}