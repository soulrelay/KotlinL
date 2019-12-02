
fun main() {
    //sampleStart
    val items = listOf(1, 2, 3, 4, 5)
    // Lambdas 表达式是花括号括起来的代码块。
    items.fold(0, { acc: Int, i: Int ->
        // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // lambda 表达式中的最后一个表达式是返回值:
        result
    })
    // lambda 表达式的参数类型是可选的，如果能够推断出来的话:
    val joinedToString = items.fold("Elements:", { acc, i -> "$acc $i" })
    // 函数引用也可以用于高阶函数调用:
    val product = items.fold(1, Int::times) //sampleEnd
    println("joinedToString = $joinedToString")
    println("product = $product")


    //sampleStart
    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun // OK
    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }

    val result = runTransformation(repeatFun) // OK
    //sampleEnd
    println("result = $result")

//    val intFunction: (String, Int) -> String = IntTransformer()
//    val result1 = runTransformation(intFunction)
//    println("result1 = $result1")

    //sampleStart
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus
    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))
    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // 类扩展调用 //sampleEnd

}

//class IntTransformer : (String, Int) -> String {
//    override operator fun invoke(x: String, y: Int): String =  TODO()
//}

