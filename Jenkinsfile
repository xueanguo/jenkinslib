#!groovy

@Library('jenkinslib') _

String buildType = "${env.buildType}"
String buildShell = "${env.buildShell}"

String srcUrl = "${env.srcUrl}"
String branchName = "${env.branchName}"

def tool = new org.devops.tools()
def build = new org.devops.build()

pipeline{
    agent {
        node {
            label "master"
        }
    }
    stages{
        stage(Checkout){
            steps{
                script{
                    checkout([$class: 'GitSCM', branches: [[name: "${branchName}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '27c1c7d5-b863-4313-ad77-ac0bf0e19578', url: "${srcUrl}"]]])
                }
            }
        }

        stage("Build"){
            steps{
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
                    currentBuild.description="构建成功"
            }
        }
        failure{
            script{
                    currentBuild.description+="构建失败"
            }
        }
        aborted{
            script{
                    currentBuild.description+="构建取消"
            }
        }
    }
}


