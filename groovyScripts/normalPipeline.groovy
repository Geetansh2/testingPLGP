
pipeline {
    agent any
    parameters {
        string 'name'
    }

    stages {
        stage('Starting job') {

            steps {
                echo "$name"
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
