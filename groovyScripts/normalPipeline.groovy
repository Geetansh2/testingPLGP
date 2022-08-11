options {
    skipDefaultCheckout(true)
}
    stages{
        stage('Hello'){
            steps{
                echo 'Hello world'
            }
        }
        stage('Name'){
            steps{
               withGroovy(tool:'4.0.4'){
                   sh 'groovy --version'
               }
            }
        }

    }
    post{
        always{
            emailext body: 'Summary', subject: 'Pipeline Status new', to: 'geetanshbhatia12@gmail.com'
        }
    }

