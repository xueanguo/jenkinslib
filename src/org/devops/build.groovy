package org.devops
//构建类型

def Build(buildType,buildShell){

    def buildTools = ["mvn":"M2","ant":"ANT","gradle":"GRADLE"]
    buildHome = tool buildTools[buildType]

    sh "${buildHome}/bin/${buildType} ${buildShell}"
}
