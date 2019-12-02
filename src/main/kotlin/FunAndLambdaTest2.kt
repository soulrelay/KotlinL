
import java.util.*

fun sum1(x: Int, y: Int): Int {
    return x + y
}

fun sum2(x: Int, y: Int) = x + y

// sum2 函数字面量： 匿名函数
val sum3 = fun(x: Int, y: Int) = x + y
val s3 = (fun(x: Int, y: Int) = x + y)(1, 1)
val s32 = (fun(x: Int, y: Int) = x + y).invoke(1, 1)

// Lambda
val sum4 = { x: Int, y: Int -> x + y }
val s4 = { x: Int, y: Int -> x + y }(1, 1)
val s42 = { x: Int, y: Int -> x + y }.invoke(1, 1)

val sum5: (Int, Int) -> Int = { x, y -> x + y }

// 高阶函数
fun repeat(n: Int, body: () -> Unit) {
    for (i in 1..n) {
        body()
    }
}

// 类型别名
typealias At = (String) -> Int

typealias Bt = (Int) -> Boolean
typealias Ct = (String) -> Boolean

val length: At = { x -> x.length }
val isOdd: Bt = { x -> x % 2 == 1 }
// 高阶函数（复合函数）
val filterOdd: Ct = { x ->
    isOdd(length(x))
}

fun filter(f: (Int) -> Boolean, integerList: List<Int>) {
    for (i in integerList) {
        if (f(i)) {
            println(i)
        }
    }
}

fun lambdaDemo() {
    filter({ x -> x % 2 == 1 }, listOf(1, 2, 3, 4, 5, 6, 7))
}

fun main(args: Array<String>) {
    val list = listOf("a", "abc", "abcbdf", "adsfeeff", "qwedddsssssdd")
    // 过滤出 list 中字符串长度是奇数的元素
    val result = list.filter(filterOdd)
    println(result)

    repeat(3) {
        println("A")
    }

    // 1 + 2 + 。。。 + 100
    var sum = 0
    var i = 1
    repeat(100) {
        sum += i
        i++
    }
    println("sum = $sum")



    sum1(1, 1)
    sum2(1, 1)
    sum3(1, 1)
    sum4(1, 1)
    sum5(1, 1)
    println("s3 = $s3")
    println("s32 = $s32")
    println("s4 = $s4")
    println("s42 = $s42")
    println("sum5 = "+ sum5(1,1))
    println("-----------------------")
    lambdaDemo()
}