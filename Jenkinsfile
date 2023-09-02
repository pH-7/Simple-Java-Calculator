pipeline {
    agent any
    stages{
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t siowyenchong/simple-java-calculator .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
	                withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
					    sh 'docker login -u siowyenchong -p ${dockerhubpwd}'
					}
                   sh 'docker push siowyenchong/simple-java-calculator'
                }
            }
        }
    }
}


