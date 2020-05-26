package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

fun main() {

    //不阻塞线程，返回一个Job，可以取消协程，可以通过await获取协程返回值，用法类似dart的async，
    // 只不过dart单线程通过微任务队列（Microtask Queue)和事件队列（Event Queue）去实现类似”协程“的异步任务
    GlobalScope.async{ //也可以换成GlobalScope.launch或runBlocking

        val result = async{
            delay(1000L)
            1
        }

        println("${result.await()}") //挂起当前协程直到获取返回值
    }

    Thread.sleep(1200L) //如果当前线程不等待，协程将不能执行完毕
    println("----所在线程执行完了----")
}