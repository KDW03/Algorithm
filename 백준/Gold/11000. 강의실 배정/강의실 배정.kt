import java.util.*

fun main() {

    // 수업에 사용할 최소의 강의실 개수
    // 일찍 시작하는 수업부터 차례대로 처리 하자
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() //수업 개수
    var result = 0
    val arr = arrayOfNulls<Pair<Int, Int>>(n)
    repeat(n) { idx ->
        br.readLine().split(" ").let {
            arr[idx] = Pair(it[0].toInt(), it[1].toInt())
        }
    }
    arr.sortBy { it?.first }

    val q = PriorityQueue<Int>() // end 시간 저장
    for (i in arr) {
        if (q.isNotEmpty()) {
            if (i?.first!! >= q.peek()) {
                q.poll()
                q.add(i.second)
            } else {
                result++
                q.add(i.second)
            }
        } else {
            result++
            q.add(i?.second)
        }
    }
    println(result)
}




