package useContract

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
class UseContract {
    fun test() {
//        var str1 : String = "string1"
        var str1: String
//        var str2 : String = "string2"
        var str2: String

        runWithoutContract {
            str1 = "krxk1"
        }
        run {
            str2 = "krxk2"
        }

        println(str1)
        println(str2)

        val str3: String? = "krxk3"
        if (!str3.isNullOrEmpty()) {
            println(str3)
        }
        if (!str3.isNullOrEmptyWithoutContract()) {
            println(str3.length)
        }

        val integer = 1
        println(TryInfix(10) add integer)

        testLambda()
    }
}

@ExperimentalContracts
inline fun <T, R> T.runWithoutContract(block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE) // 声明 block 会调用一次
    }
    return block()
}

@ExperimentalContracts
inline fun CharSequence?.isNullOrEmptyWithoutContract(): Boolean {
    contract {
        // returns 返回 SimpleEffect, 后者包含中缀函数 implies
        returns(false) implies (this@isNullOrEmptyWithoutContract != null) // 表明本函数返回时意味着已经检查了空情况
    }
    return this == null || this.isEmpty()
}

/**
 * 补充测试中缀函数
 */
class TryInfix(private var value: Int) {
    infix fun add(a: Int): Int {
        this.value += a
        return value
    }
}

/**
 * 测试 lambda 表示式
 */
fun testLambda() {
    /**
     * let 使用此模式
     */
    val str: String = "test lambda"
    { it: String -> // 默认以 it 作为接收参数
        println(it)
    }(str)
    /**
     * 而 apply 使用的是扩展函数，故使用 this 指针作为接收器
     */
}