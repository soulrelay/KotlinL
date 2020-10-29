package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * @Description:
 * @Author: SuS
 * @CreateDate: 2020/8/4 8:19 PM
 */
fun main()  {
    runBlocking(Dispatchers.Default) {
        for (i in 0 .. 10) {
            println("aaaaa ${Thread.currentThread().name}")
            delay(1000) // 这是一个挂起函数
            println("bbbbb ${Thread.currentThread().name}")
        }
    }
}