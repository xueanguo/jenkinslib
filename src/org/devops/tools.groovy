package org.devops

//打印内容
// def PrintMes(content){
//    println(content)
// }


def PrintMes(value,color){
    colors = ['red' : "\033[1;31;40m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'green' : "\033[1;32;40m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'yellow' : "\033[1;33;40m >>>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'blue' : "\033[1;34;40m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              'mauve' : "\033[1;35;40m >>>>>>>>>>>>${value}<<<<<<<<<<<< \033[0m",
              ]
    ansiColor('xterm') {
        println(colors[color])
    }
}


//格式：\033[显示方式;前景色;背景色m正文\033[0m