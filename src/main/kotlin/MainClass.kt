class MainClass {
    interface MyInterface {
        fun print()
    }

    companion object : MyInterface {
        @JvmField
        val a: Int = 1
        override fun print() {
            TODO("Not yet implemented")
        }

        @JvmStatic
        fun test() {
            println(2)
        }
    }
}