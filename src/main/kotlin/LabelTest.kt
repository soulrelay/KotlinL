
/**
 * kotlin 标签
 */

fun returnDemo1(){
    val intArray = intArrayOf(1,2,3,4,5,6,7)
    intArray.forEach {
        if(it == 3) return
        println(it)
    }
}

//显示标签
fun returnDemo2(){
    val intArray = intArrayOf(1,2,3,4,5,6,7)

    intArray.forEach here@ {
        if(it == 3) return@here//指令跳转到lambda表达式标签here@处。
        println(it)
    }
}

//隐式标签
//所谓的隐式标签就是该标签与接收该lambda的函数同名
fun returnDemo3(){
    val intArray = intArrayOf(1,2,3,4,5,6,7)
    intArray.forEach {
        if(it == 3) return@forEach
        println(it)
    }
}

fun breakDemo1(){
    for (out in 1..5){
        println("outer $out")
        for (inner in 1..5){
            if(inner % 2 == 0){
                break //只跳出本层循环
            }
            println("inner $inner")
        }
    }
}

fun breakDemo2(){
  outer@  for (out in 1..5){
        println("outer $out")
        for (inner in 1..5){
            if(inner % 2 == 0){
                break@outer //跳到outer@处
            }
            println("inner $inner")
        }
    }
}




fun main() {

    returnDemo1() //输出1，2
    println("--------------------")
    returnDemo2() //输出1，2，4，5，6，7
    println("--------------------")
    returnDemo3() //输出1，2，4，5，6，7
    println("--------------------")
    breakDemo1()
    println("--------------------")
    breakDemo2()


}