package others

sealed class SealedClass {
    abstract fun test()
}

class SealedClassChildB : SealedClass() {
    override fun test() {
        TODO("Not yet implemented")
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}

object SealedClassChild : SealedClass() {
    override fun test() {
        TODO("Not yet implemented")
    }

    fun print() {
        println("Print")
    }
}

fun handler(sealedClass: SealedClass) {
    when (sealedClass) {
        SealedClassChild -> {
            SealedClassChild.print()
        }

        is SealedClassChildB -> {

        }

        is TryExtendSealedClass -> {

        }
    }
}