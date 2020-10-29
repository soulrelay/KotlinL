package coroutines

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

/**
 * @Description:
 * @Author: SuS
 * @CreateDate: 2020/8/4 4:47 PM
 *
 * Kotlin中可以很方便的使用自定义线程池作为协程上下文，并且可以在不使用CountDownLatch跟Callable+Future的情况下更简单的实现主线程等待线程池中任务执行完毕的需求。
 *
 * 以上代码中首先创建了一个3个线程的定长线程池，然后经由launch创建一个同步协程作为父协程，接着在父协程内部循环创建了5个使用自定义线程池的异步子协程，
 * 最终由父协程的join()方法实现等待子协程全部执行完毕。当然，千万记得关闭线程池，以免造成不必要的资源浪费；建议将自定义线程池作为全局变量重复利用
 */

fun main() {
    runBlocking {
        //创建自定义线程池
        val coroutineDispatcher = Executors.newFixedThreadPool(3).asCoroutineDispatcher()
        launch {
            //在父协程中创建子协程
            repeat(5) {
                //使用自定义线程池执行协程
                async(coroutineDispatcher) {
                    Thread.sleep(1000)
                    println("${Thread.currentThread().name}")
                }
            }
        }.join()//等待子协程执行完毕
        //关闭自定义线程池
        coroutineDispatcher.close()
        println("子协程执行完啦!!!!")
    }
}