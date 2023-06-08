import java.util.*
import java.util.Queue

interface Q {
    fun push(x: Int)
    fun pop()
    fun size()
    fun empty()
    fun front()
    fun back()
}

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val q = Queue()
    repeat(n) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "push" -> q.push(input[1].toInt())
            "pop" -> q.pop()
            "size" -> q.size()
            "empty" -> q.empty()
            "front" -> q.front()
            "back" -> q.back()
        }
    }
    println(q.getLog())
}

class Queue() : Q {
    private val q: Queue<Int> = LinkedList()
    private val sb = StringBuilder()

    override fun push(x: Int) {
        q.add(x)
    }

    override fun front() {
        sb.append(
            if (isEmpty()) -1 else q.peek()
        ).append("\n")
    }

    override fun back() {
        sb.append(
            if (isEmpty()) -1 else q.last()
        ).append("\n")
    }

    override fun size() {
        sb.append(q.size).append("\n")
    }

    override fun pop() {
        sb.append(if (isEmpty()) -1 else q.poll()).append("\n")
    }

    override fun empty() {
        sb.append(if (isEmpty()) 1 else 0).append("\n")
    }

    fun getLog() = sb.toString()

    private fun isEmpty() = q.isEmpty()
}


