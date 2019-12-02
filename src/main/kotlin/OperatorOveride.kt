
/**
 * 基本运算符
 * 1.任何类可以定义或者重载父类的基本运算符
 * 2.通过运算符对应的具名函数来定义
 * 3.对参数的个数做要求，对参数和返回值类型不做要求
 *
 * Complex表示复数
 * 参数的类型和返回值的类型不关注
 */
class Complex(var real: Double, var imaginary: Double){
    operator fun plus(other: Complex): Complex { //operator表示操作符, plus表示加法运算, other表示传入的另一个参数
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun plus(other: Int): Complex { //operator表示操作符, plus表示加法运算, other表示传入的另一个参数
        return Complex(real + other, imaginary + other)
    }

    operator fun plus(other: Any): Int { //operator表示操作符, plus表示加法运算, other表示传入的另一个参数
        return real.toInt()
    }

    operator fun invoke(): Double {
        return Math.hypot(real, imaginary) //计算直角三角形的斜边长
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

fun main(args: Array<String>) {
    val c1 = Complex(3.0, 4.0) //3 + 4i
    val c2 = Complex(2.0, 8.5) //2 + 8.5i

    println(c1 + c2) //5 + 12.5i
    println(c1 + 5) //8 + 9i
    println(c1 + "HelloWorld") //3

    println(c1()) //执行invoke（）方法

    val array = arrayOf("name","age","sex") //构造一个新的数组
    if ("name" in array) { //判断字符串name是否在数组中
        println(array[array.indexOf("name") + 1]) //找到字符串name在数组中的位置并打印出下一个字符串
    }
}