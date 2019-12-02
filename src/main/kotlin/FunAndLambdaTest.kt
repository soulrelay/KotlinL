
fun test(a: Int = 0, b: Int = 1) = println(a - b)

fun main() {
    test()
    test(2)
    test(b = 2)//显示指定参数名
    test(3, 2)
    test(a = 3)
    println("-----------------")
    println(A().method(1))
    println(B().method(2))

    println("-----------------")
    test2(b = 3) //具名参数（named argument）
    test2(4, b = 3)
    println("-----------------")
    test3(2, 3, ::test)
    test3(2, 3, { a, b -> println(a - b) })

    test3(2, 3) { a, b ->
        println(a - b)
    }
    test3(2) { a, b ->
        println(a - b)
    }

    test3(b = 2) { a, b ->
        println(a - b)
    }


    test3 { a, b -> println(a - b) }

    test4(1, 2, 3, 4)
    test4(a = 1, d = 5)

    test4("a", "b", "c")

    //可变参数可以借助于spread operator以具名参数的形式传递
    test4(strings = *arrayOf("a", "b", "c"))
    val arrays = arrayOf("a", "b", "c")
    test4(*arrays)


}


fun test2(a: Int = 1, b: Int) = println(a - b)

/**
 * 如果函数的最后一个参数是lambda表达式，而且在调用时是位于圆括号之外，那么就可以不指定lambda表达式的具名参数名
 */
fun test3(a: Int = 1, b: Int = 2, compute: (x: Int, y: Int) -> Unit) {
    compute(a, b)
}

fun test4(a: Int, b: Int = 2, c: Int = 3, d: Int) = println(a + b + c + d)

fun test4(vararg strings: String) {
    println(strings.javaClass)
    strings.forEach { println(it) }
}


open class A {
    open fun method(a: Int, b: Int = 4) = a + b
}

/*
  对于重写的方法来说，子类所拥有的重写方法会使用与父类相同的默认参数值
  在重写一个拥有默认参数值的方法时，方法签名中必须要将默认参数值省略掉
 */
class B : A() {
    override fun method(a: Int, b: Int) = a + b
}


fun myPrint(name: String): Unit {
    println(name)
    return Unit
}

//单表达式函数，函数的返回类型如果可以通过类型推断判断出来，那么返回类型可以省略掉
fun add(a: Int, b: Int) = a + b

/**
 * 显示返回类型
 *
 * 拥有方法体的函数必须要显示指定返回类型，除非函数返回Unit，这时返回类型就可以省略掉，
 * Kotlin并不会推断拥有块体的函数的返回类型，因为这种函数可能拥有非常复杂的控制流程，
 * 返回类型对于阅读代码的人来说就不是那么明显了（有时，对于编译器来说亦如此）
 */






