package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Description:
 * @Author: SuS
 * @CreateDate: 2020/8/4 7:35 PM
 *
 * https://segmentfault.com/a/1190000020206667?utm_source=tag-newest
 */
fun main() {
    runBlocking(Dispatchers.IO) {

        val job1 = launch {
            for (i in 0..10) {
                println("normal launch $i ${Thread.currentThread().name} #####")
                delay(100)
            }
        }

        val job2 = launch {
            for (i in 0..10) {
                println("normal launch $i ${Thread.currentThread().name} -----")
                delay(100)
            }
        }

        job1.join()
        job2.join()

        println("all job finished")
    }
}