import others.MyInterface2

enum class MyEnum(val key: String) : MyInterface2 {
    Monday("小红") {
        override fun display() {
            TODO("Not yet implemented")
        }

        override fun show() {
            TODO("Not yet implemented")
        }
    },
    Tuesday("小明") {
        override fun display() {
            TODO("Not yet implemented")
        }

        override fun show() {
            TODO("Not yet implemented")
        }
    },
    Wednesday("小黑") {
        override fun display() {
            TODO("Not yet implemented")
        }

        override fun show() {
            TODO("Not yet implemented")
        }
    };

    abstract fun display()
}

