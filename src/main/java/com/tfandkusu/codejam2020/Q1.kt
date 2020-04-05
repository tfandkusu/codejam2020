package com.tfandkusu.codejam2020

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val t = reader.nextInt()
    (1..t).map { x ->
        val n = reader.nextInt()
        // 正方行列を読み込む
        val m = Array(n) { IntArray(n) }
        (0 until n).map { i ->
            (0 until n).map { j ->
                m[i][j] = reader.nextInt()
            }
        }
        // 答えを作る
        // 対角成分の合計
        val k = (0 until n).sumBy { m[it][it] }
        // 重複要素のある行の数
        val r = (0 until n).map { m[it] }.map { it.distinct().size != n }.count { it }
        // 重複要素のある列の数
        val c = (0 until n).map { j -> (0 until n).map { m[it][j] } }.map { it.distinct().size != n }.count { it }
        // 結果出力
        println("Case #%d: %d %d %d".format(x, k, r, c))
    }
}
