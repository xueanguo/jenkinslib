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
