package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //runBlocking{} //会使当前线程阻塞，直到协程执行完毕
    //启动协程
    runBlocking{//顶层父协程
        launch{//子协程
            delay(1000L)
            println("----所在协程执行完了1----")
        }

        launch{//子协程
            delay(500L)
            println("----所在协程执行完了2----")
        }
    }
    println("上面协程结束后才打印3")
}