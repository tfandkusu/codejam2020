package com.tfandkusu.codejam2020

import java.lang.Integer.max
import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val t = reader.nextInt()
    (1..t).map { x ->
        val s = reader.next()
        // 現在レベル
        var d = 0
        val output = s.map { it - '0' }.joinToString(separator = "") {
            val ret =
                // itのレベルまで下げる
                (0 until max(0, (d - it))).map { ')' }.joinToString(separator = "") +
                        // itのレベルまで上げる
                        (0 until max(0, (it - d))).map { '(' }.joinToString(separator = "") +
                        // itを出力
                        it.toString()
            // 現在レベルを記録する
            d = it
            // このブロックの結果を返却
            ret
        } +
                // 終端でレベル0になるようにする
                ")".repeat(d)
        // 結果を出力
        println("Case #%d: %s".format(x, output))
    }
}
