#!groovy

@Library('jenkinslib') _

String buildType = "${env.buildType}"
String buildShell = "${env.buildShell}"

String srcUrl = "${env.srcUrl}"
String branchName = "${env.branchName}"

if("${runOpts}" == "GitlabPush"){
    branchName = branch - "refs/heads/"
    currentBuild.description = "Trigger by username:${userName} branch:${branchName}"
}

def tool = new org.devops.tools()
def build = new org.devops.build()
def gitlab = new org.devops.gitlab()
def toemail = new org.devops.toemail()

pipeline{
    agent {
        node {
            label "master"
        }
    }
    stages{
        stage("Checkout"){
            steps{
                script{
                    tool.PrintMes("Checkout","green")
                    checkout([$class: 'GitSCM', branches: [[name: "${branchName}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '27c1c7d5-b863-4313-ad77-ac0bf0e19578', url: "${srcUrl}"]]])
                }
            }
        }

        stage("Build"){
            steps{
                script{
                    tool.PrintMes("Build","blue")
                    build.Build(buildType,buildShell)
                }

//            withCredentials([usernamePassword(credentialsId: '27c1c7d5-b863-4313-ad77-ac0bf0e19578', passwordVariable: 'password', usernameVariable: 'username')]) {
//                println(username)
//                println(password)
//            }
            }
        }
    }
    post{

        always{
            echo "========always========"
        }
        success{
            script{
                if("${runOpts}" == "GitlabPush"){
                    gitlab.ChangeCommitStatus(projectId,commitSha,"success")
                    toemail.Email("流水线构建成功",userEmail)
                }
            }
        }
        failure{
            script{
                if("${runOpts}" == "GitlabPush"){
                    gitlab.ChangeCommitStatus(projectId,commitSha,"failed")
                    toemail.Email("流水线构建失败",userEmail)
                }
            }
        }
        aborted{
            script{
                if("${runOpts}" == "GitlabPush"){
                    gitlab.ChangeCommitStatus(projectId,commitSha,"canceled")
                    toemail.Email("流水线构建取消",userEmail)
                }
            }
        }
    }
}


