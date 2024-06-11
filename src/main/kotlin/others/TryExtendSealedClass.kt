package others

class TryExtendSealedClass : SealedClass() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun test() {
        TODO("Not yet implemented")
    }

    fun display() {

    }
}