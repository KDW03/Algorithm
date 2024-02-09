import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val highQ: PriorityQueue<Int> = PriorityQueue()
    val lowQ: PriorityQueue<Int> = PriorityQueue { o1, o2 -> o2 - o1 }
    var mid = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(n - 1) {
        sb.append(mid).append("\n")
        val num = br.readLine().toInt()
        if (num >= mid) {
            highQ.add(num)
        } else {
            lowQ.add(num)
        }
        val hSize = highQ.size
        val lSize = lowQ.size

        if (hSize - lSize >= 2) {
            lowQ.add(mid)
            mid = highQ.poll()
        } else if (lSize - hSize >= 1) {
            highQ.add(mid)
            mid = lowQ.poll()
        }
    }
    sb.append(mid).append("\n")
    print(sb.toString())
}
