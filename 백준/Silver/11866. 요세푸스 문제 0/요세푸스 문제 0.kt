import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder().append("<")
    val (n,k) = br.readLine().split(' ').map { it.toInt() }
    val q : Queue<Int> = LinkedList()
    for (i in 1 .. n)
        q.add(i)
    var count = 1
    while (q.size != 1){
        val temp = q.poll()
        if (count == k) {
            sb.append("${temp}, ")
            count = 1
        } else {
            count++
            q.add(temp)
        }
    }
    println(sb.append(q.poll()).append(">").toString())
}
