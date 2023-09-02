import java.util.Comparator
import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val answer = LinkedList<Char>()

    val alphaMap = br.readLine().toList().groupingBy { it }.eachCount().toSortedMap(Comparator.reverseOrder())

    for ((k, v) in alphaMap) {
        // 짝수라면
        if (v % 2 == 0) {
            val t = v / 2
            repeat(t) {
                answer.addFirst(k)
                answer.addLast(k)
            }
        } else {
            if (answer.size % 2 != 0) {
                println("I'm Sorry Hansoo")
                return
            }
            val t = v / 2
            repeat(t) {
                answer.addFirst(k)
                answer.addLast(k)
            }
            answer.add(answer.size / 2, k)
        }

    }
    println(answer.joinToString(""))
}