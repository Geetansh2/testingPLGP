pipeline {
    agent any
    stages {
        stage('Starting job') {
            steps {
                echo 'Starting job'
            }
        }
        stage('Run testNg suite job') {
            steps {
                build job: 'RunGradleTestNGSuite'
            }
        }
    }

    post {
        always {
            emailext body: 'Summary', subject: 'Pipeline Status new', to: 'geetanshbhatia12@gmail.com'
        }
    }
}
