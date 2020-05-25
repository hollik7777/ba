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
                nexusPublisher nexusInstanceId: 'nexus-local-3', nexusRepositoryId: 'maven-snapshots', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/demo-demo-SNAPSHOT.jar']], mavenCoordinate: [artifactId: 'demo', groupId: 'com.example', packaging: 'jar', version: 'demo-SNAPSHOT']]]
            }
        }
    }
}
