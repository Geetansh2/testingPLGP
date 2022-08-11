pipeline{
    agent any
    stages{
        stage('Hello'){
            steps{
                echo 'Hello world'
            }
        }
        stage('Name'){
            steps{
                echo 'My name is Geetansh'
            }
        }

    }
    post{
        always{
            emailext body: 'Summary', subject: 'Pipeline Status new', to: 'geetanshbhatia12@gmail.com'
        }
    }

}