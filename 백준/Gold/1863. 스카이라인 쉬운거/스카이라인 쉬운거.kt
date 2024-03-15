import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var answer = 0
    val stack = Stack<Int>()
    stack.add(0)
    outer@for(i in 0 until n) {
        val (a,h) = br.readLine().split(" ").map { it.toInt() }

        while (stack.isNotEmpty() && stack.peek() >= h) {
            // 만약 같은거라면 동일 건물
            if (stack.peek() == h) continue@outer
            // 높이가 큰것들은 건물 종료되었으므로 빼주기
            stack.pop()
            answer++
        }

        // 기존에 있던 새로운 건물 추가
        stack.add(h)
    }

    while (stack.isNotEmpty() && stack.peek() != 0) {
        stack.pop()
        answer++
    }

    println(answer)
}