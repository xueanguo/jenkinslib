#!groovy

@Library('jenkinslib') _

String buildType = "${env.buildType}"
String buildShell = "${env.buildShell}"
String buildUser = "${env.BUILD_USER}"

def tool = new org.devops.tools()
def build = new org.devops.build()

pipeline{
    agent {
        node {
            label "master"
        }
    }
    stages{
        stage("Build"){
            steps{
                echo "========executing A========"
                script{
                    tool.PrintMes("Build","yellow")
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
            script{
                currentBuild.description +=buildUser+"构建成功"
            }
        }
        failure{
            script{
                currentBuild.description +=buildUser+"构建失败"
            }
        }
        aborted{
            script{
                currentBuild.description +=buildUser+"构建取消"
            }
        }
    }
}
