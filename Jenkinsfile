#!groovy

@Library('jenkinslib') _

def tools = new org.devops.tools()

pipeline{
    agent none
    stages{
        stage("A"){
            steps{
                echo "========executing A========"
                script{
                    tools.PrintMes("this is my lib!")
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
}
