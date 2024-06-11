package others

interface Base {
    fun print()
}

/**
 * 此类用于执行任务
 */
class BaseImpl(private val x : Int) : Base {
    override fun print() {
        print("$x\n")
    }
}

/**
 * Context，分发聚合。
 * 此类用于分配任务
 */
class Derived(b : Base) : Base by b {
    /**
     * 覆盖委托对象的方法
     */
    override fun print() {
        println(100)
    }
}

class Delegate {
    fun test() {
        val b = BaseImpl(10)
        Derived(b).print()
    }

}