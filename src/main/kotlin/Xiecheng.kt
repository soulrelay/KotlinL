import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //启动协程
    runBlocking{//顶层父协程
        launch{//子协程
            delay(1000L)
            print("----所在协程执行完了----")
        }

        launch{//子协程
            delay(500L)
            print("----所在协程执行完了----")
        }
    }
    print("上面协程结束后才打印")
}