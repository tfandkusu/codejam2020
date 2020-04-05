package com.tfandkusu.codejam2020

import java.util.*


/**
 * 活動を表すデータ
 * @param s 開始時刻
 * @param e 終了時刻
 * @param i 何番目の活動か
 * @param cj CとJどっちがやるか
 */
data class Time(val s: Int, val e: Int, val i: Int, val cj: String)

fun main() {
    val reader = Scanner(System.`in`)
    val t = reader.nextInt()
    (1..t).map { x ->
        // 活動中配列
        val c = Array(24 * 60) { false }
        val j = Array(24 * 60) { false }
        val n = reader.nextInt()
        // 結果配列を作る
        val times = (0 until n).map {
            // 入力する
            val s = reader.nextInt()
            val e = reader.nextInt()
            Time(s, e, it, "")
        }.sortedBy {
            // 時系列にする
            it.s
        }.map { time ->
            // 活動中でない人に割り当てる
            if (!c[time.s]) {
                // 割当たったら、活動中の時刻をtrueにする
                (time.s until time.e).map { c[it] = true }
                // やった人を記録する
                time.copy(cj = "C")
            } else if (!j[time.s]) {
                (time.s until time.e).map { j[it] = true }
                time.copy(cj = "J")
            } else {
                time
            }
        }.sortedBy { it.i }
        // 結果出力
        var output = ""
        if (times.none { it.cj == "" })
        // すべての活動が割当たった
            output = times.joinToString("") { it.cj }
        else
        // 割当たらなかった活動がある
            output = "IMPOSSIBLE"
        println("Case #%d: %s".format(x, output))
    }
}

