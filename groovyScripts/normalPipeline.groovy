pipeline {
    agent any
    stages {
        stage('Starting job') {
            steps {
                echo '$Name'
            }
        }
        stage('Run testNg suite job') {
            steps {
                build job: 'RunGradleTestNGSuite'
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
