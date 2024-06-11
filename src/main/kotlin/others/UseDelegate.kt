package others

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 类委托
 */
interface HomeDao {
    fun getAllHomeData(): List<String>
}

interface MoneyDao {
    fun getAllMoneyData() : IntArray
}

class HomeDaoImpl : HomeDao {
    override fun getAllHomeData(): List<String> {
        return listOf("home")
    }
}

class MoneyDaoImpl : MoneyDao {
    override fun getAllMoneyData(): IntArray {
        return intArrayOf(1,2,3)
    }
}

class HomeService(homeDaoImpl: HomeDaoImpl, moneyDaoImpl: MoneyDaoImpl) : HomeDao by homeDaoImpl,
    MoneyDao by moneyDaoImpl {
    fun getRedisData() : String {
        return "RedisData"
    }

}

/**
 * 属性委托
 */
class MyAttrDelegate : ReadWriteProperty<Nothing?, String> {
    private var value = ""
    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        return value
    }

    override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
        this.value = value
    }
}

class AttrContainer {
    var value : String by MyAttrDelegateInClass()
}

class MyAttrDelegateInClass : ReadWriteProperty<AttrContainer, String> {
    private var myvar : String = ""
    override fun getValue(thisRef: AttrContainer, property: KProperty<*>): String {
        println("call get here")
        return myvar
    }

    override fun setValue(thisRef: AttrContainer, property: KProperty<*>, value: String) {
        println("set here")
        this.myvar = value
    }
}

/**
 * 属性委托 - 延迟委托
 */
class InitLazyDelegate {
    val value : Boolean by lazy {
        for (i in 1..10) {
            println("init here $i")
        }
        true
    }
}

/**
 * 测试类
 */
class UseDelegate {
    fun test() {
        // 类委托
        val homeService = HomeService(HomeDaoImpl(), MoneyDaoImpl())
        println(homeService.getRedisData())
        println(homeService.getAllHomeData())
        homeService.getAllMoneyData().forEach {
            println(it)
        }

        // 属性委托
        var attrTest : String by MyAttrDelegate()
        attrTest = "123"
        println(attrTest)

        AttrContainer().apply {
            value = "234"
            println(value)
        }

        // 延迟委托
        val initLazyDelegate = InitLazyDelegate()
        println(initLazyDelegate.value)
        println(initLazyDelegate.value)

        // 监听委托
        var observeValue : String by Delegates.observable("hello") { _, oldValue, newValue ->
            println("oldValue: $oldValue newValue: $newValue")
        }
        observeValue = "345"
        observeValue = "456"
        println(observeValue)
    }
}