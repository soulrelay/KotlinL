package callback

/**
 * @Description:
 * @Author: SuS
 * @CreateDate: 2020/11/11 4:53 PM
 */

fun main() {
    Action().apply {
        registerListener {
            onAction1 {
                println(it)
            }
            onAction2(::println)
        }
    }.launchGo()

}