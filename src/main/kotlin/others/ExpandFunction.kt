package others

class ExpandFunction {
    fun test() {
        val arr = intArrayOf(1,2,3)
        arr.krxk(1)
    }
}

/**
 * 扩展函数
 */
fun IntArray.krxk(index : Int) {
    println(this[index])
}

fun testVoidType() {
    val myList = listOf<String?>("abc", "dde", null)
    myList.forEach() {
        it?.let {
            println(it)
        }
    }
}
