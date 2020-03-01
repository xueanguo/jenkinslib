#!groovy

@Library('jenkinslib') _

def tools = new org.devops.tools()

pipeline{
    agent none
    stages{
        stage("获取代码"){
            steps{
                echo "========executing A========"
                script{
                    tools.PrintMes("获取代码","red")
                    mvnHome = tool 'M2'
                    sh "${mvnHome}/bin/mvn --version"
                }
            withCredentials([usernamePassword(credentialsId: '27c1c7d5-b863-4313-ad77-ac0bf0e19578', passwordVariable: 'password', usernameVariable: 'username')]) {
                println(username)
                println(password)
            }
            }
        }
        stage("打包编译"){
            steps{
                echo "========executing A========"
                script{
                    tools.PrintMes("打包编译","green")
                }
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}
