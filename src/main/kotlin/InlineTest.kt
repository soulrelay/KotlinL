
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * kotlin的内联函数的使用
 * https://www.jianshu.com/p/4f29c9724b33
 */
fun main() {
    val lock = ReentrantLock()
    method(lock) {"我是body的方法体"}//lock是一个Lock对象

    val user = 1

    val result = user.let {
        1000
    }
    //let返回最后一行
    println("result: $result")

}


inline fun <T> method(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}