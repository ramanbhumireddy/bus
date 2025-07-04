pipeline {
    agent any

    tools {
        jdk 'JDK_21'          // Make sure this matches the name in Jenkins Global Tool Configuration
        gradle 'gradle_9.0.0'   // Likewise, match the name of your configured Gradle version
    }



    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/ramanbhumireddy/bus.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Package') {
            steps {
                sh './gradlew bootJar'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            junit 'build/test-results/test/*.xml'
        }
        success {
            echo 'Build and tests succeeded.'
        }
        failure {
            echo 'Something failed. Investigate before deploying.'
        }
    }
}