package callback

/**
 * @Description:
 * @Author: SuS
 * @CreateDate: 2020/11/11 4:36 PM
 */
class Action {

    //https://youkmi.blog.csdn.net/article/details/86695094
    // 如何让你的回调更具Kotlin风味

    private lateinit var mActionListener: ActionListener

    fun registerListener(block: ActionListener.() -> Unit) {//带ActionListener返回值的lamba
        mActionListener = ActionListener().also(block)
    }

    fun launchGo() {
        if (::mActionListener.isInitialized) {
            mActionListener.action1?.invoke("action1")
        }

        if (::mActionListener.isInitialized) {
            mActionListener.action2?.invoke("action2")
        }
    }

    inner class ActionListener {
        internal var action1: ((String) -> Unit)? = null
        internal var action2: ((String) -> Unit)? = null

        fun onAction1(action: (String) -> Unit) {
            action1 = action
        }

        fun onAction2(action: (String) -> Unit) {
            action2 = action
        }
    }

}