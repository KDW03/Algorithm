import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val broken = if (m > 0) br.readLine().split(" ").map { it.toInt() }.toSet() else emptySet()
    var min = abs(n - 100)

    for (channel in 0..999999) {
        val channelStr = channel.toString()
        if (channelStr.all { it.toString().toInt() !in broken }) {
            val clicks = abs(channel - n) + channelStr.length
            min = minOf(min, clicks)
        }
    }

    println(min)
}