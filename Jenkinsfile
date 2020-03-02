#!groovy

@Library('jenkinslib') _

String buildShell = "${env.buildShell}"

def tools = new org.devops.tools()
def build = new org.devops.build()

pipeline{
    agent {
        node {
            label "master"
        }
    }
    stages{
        stage("获取代码"){
            steps{
                echo "========executing A========"
                script{
                    tools.PrintMes("获取代码","red")
                    def mvnHome = tool name: 'M2'
                    sh "${mvnHome}/bin/mvn --version"
                    echo "${buildShell}"
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
