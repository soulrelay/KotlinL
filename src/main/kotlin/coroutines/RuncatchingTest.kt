package coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

suspend fun main()  {
    val deferreds: List<Deferred<Int>> = List(10) {  // 1
        GlobalScope.async {   // 2
            if (it % 2 == 0)
                return@async it
            else
                throw Exception("The odd number comes inside the list")
        }
    }
    deferreds.map { // 3
        return@map runCatching {
            return@runCatching it.await()   // 4
        }
    }.forEach {
        it.onSuccess { value ->  // 5
            println(value)
        }.onFailure { t ->  // 6
            System.err.println(t.message)
        }
    }
}