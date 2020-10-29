package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Description:
 * @Author: SuS
 * @CreateDate: 2020/8/4 7:56 PM
 */
fun main() = runBlocking {
    val job = GlobalScope.launch {
        println("GlobalScope ${this.toString()}")
        launch {
            println("A ${this.toString()}")
            launch {
                println("A1 ${this.toString()}")
            }
        }

        launch {
            println("B ${this.toString()}")
        }
    }

    job.join()
}

