pipeline{
    agent any
    tools{
        maven 'maven'
    }

    stages{
        stage('build maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/chiehminchung/Hello-EKS']])
                sh 'mvn clean install'
            }
        }
        stage('build docker image'){
                    steps{
                        script{
//                             sh 'docker build -t chiehmin/hello-eks .'
                            sh 'docker buildx build --platform linux/amd64,linux/arm64 -t chiehmin/hello-eks .'
                            sh 'docker tag chiehmin/hello-eks:latest 654661216054.dkr.ecr.us-east-2.amazonaws.com/spring-eks:latest'
                        }

                    }
        }
        stage('push into ECR'){
            steps{

                sh 'aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 654661216054.dkr.ecr.us-east-2.amazonaws.com'
                sh 'docker push 654661216054.dkr.ecr.us-east-2.amazonaws.com/spring-eks:latest'
            }
        }
        stage('eks'){
            steps{
                // sh 'aws eks --region us-east-2 update-kubeconfig --name jam-cluster'
                sh 'kubectl apply -f k8s.yaml'

            }
        }
    }
}