package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
//GlobalScope.launch{} //不阻塞线程，返回一个Job，可以取消协程
    GlobalScope.launch {
        delay(1000L)
        println("----所在协程执行完了1----")
    }

    GlobalScope.launch {
        delay(1000L)
        println("----所在协程执行完了2----")
    }

    Thread.sleep(2000L) //如果当前线程不等待，协程将不能执行完毕
    println("----所在线程执行完了3----")
}