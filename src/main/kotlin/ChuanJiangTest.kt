fun main() {
    // 这里举例一个语言自带的一个高阶函数filter,此函数的作用是过滤掉不满足条件的值。
    val arr = arrayOf(1,3,5,7,9)
// 过滤掉数组中元素小于2的元素，取其第一个打印。这里的it就表示每一个元素。
    println(arr.filter { it < 5 }.component1())
}