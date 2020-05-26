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
        stage('Build docker image') {
             steps {
                 echo 'Building docker image....'
                 sh 'docker build -t demo-docker:latest .'

             }
         }
         stage('Publish docker image') {
              steps {
                  echo 'Publishing docker image....'
                  sh 'docker login -u admin -p Putinv_1234 localhost:8083'
                  sh 'docker tag demo-docker:latest localhost:8083/demo-docker:1'
                  sh 'docker push localhost:8083/demo-docker:1'

              }
         }
    }
}
