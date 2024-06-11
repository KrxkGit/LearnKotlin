package others

interface SingleInterface {
    fun show()
}

interface MyInterface2 {
    fun show()
}

interface CallBack {
    fun display()
}

fun request(func: CallBack) {
    func.display()
}

sealed interface SealedInterface {
    fun display()
}

interface SealInterfaceChild : SealedInterface {

}