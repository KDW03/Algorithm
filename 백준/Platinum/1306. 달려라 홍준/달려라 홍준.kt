import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()

    val sb = StringBuilder()

    // 칸수 N과 홍준이의 시야의 범위 M
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 현재 위치에서 앞뒤로 M-1칸까지 광고판이 보이는 것
    //   두 번째 줄에는 각각 칸에 있는 광고판들의 빛의 세기

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val start = m
    val end = n - m + 1
    val window = LinkedList<Int>()
    var max = -1


    for (i in 0 until end + m - 1) {

        if (window.size != 2 * m - 1) {
            max = maxOf(max, arr[i])
            window.add(arr[i])
            continue
        }

        sb.append("$max ")

        val exit = window.removeFirst()
        val enter = arr[i]
        window.add(enter)
        // 들어오는게 max보다 큰다면
        if (enter > max) {
            max = enter
            continue
        }
        // 들어오는게 max보다 크지도 않고 나가는게 max랑 같다면
        if (exit == max) {
            max = window.maxOrNull()!!
        }

    }

    sb.append(max)
    

    println(sb.toString())
}