package others

fun printText(arg: String) {
    val positives = listOf(1, 2, 3).filter { it > 0 }
    for (i in 100 downTo 1 step 2) {
        println("数字: $i")
    }
    println("字符串是: $arg")
}