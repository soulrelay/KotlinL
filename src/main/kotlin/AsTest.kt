
/**
 * Kotlin as 类型转换运算符
 * https://blog.csdn.net/u011489043/article/details/95175506
 */
fun main() {
    val y = 66
    val x: String? = y as? String
    println("x = $x")// x = null

    val y1 = null
    val x1: String? = y1 as? String
    println("x1 = $x1")   // x = null

    val string = "sssss"
    string.also(
        ::println
    )
}