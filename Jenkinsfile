#!groovy

@Library('jenkinslib') _

String buildType = "${env.buildType}"
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
        stage("build"){
            steps{
                echo "========executing A========"
                script{
                    tools.PrintMes("编译","yellow")
                    build.Build(buildType,buildShell)
                }

            withCredentials([usernamePassword(credentialsId: '27c1c7d5-b863-4313-ad77-ac0bf0e19578', passwordVariable: 'password', usernameVariable: 'username')]) {
                println(username)
                println(password)
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
