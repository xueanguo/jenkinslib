package org.devops

//打印内容
// def PrintMes(content){
//    println(content)
// }


def PrintMes(value,color){
    colors = ['red' : "\033[31m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'green' : "\033[32m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'yellow' : "\033[33m >>>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'blue' : "\033[34m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'mauve' : "\033[35m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              ]
    ansiColor('xterm') {
        println(colors[color])
    }
}


//格式：\033[显示方式;前景色;背景色m正文\033[0m