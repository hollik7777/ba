pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building....'
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh "cp /home/hollik/.m2/settings.xml settings.xml"
                sh 'mvn -s settings.xml clean deploy'

            }
        }
    }
}
