import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = ArrayList<Pair<Int,Int>>()

    repeat(n) {
        val (idx,value) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(idx,value))
    }


    arr.sortBy { it.first }
    var answer = 0

    val stack = Stack<Pair<Int,Int>>()
    stack.add(arr.first())
    var (i,v) = stack.peek()

    for ((idx,value) in arr.drop(1)) {

        if (value >= v) {
            answer += v * (idx - i)
            i = idx
            v = value
            stack.clear()
        }

        stack.add(Pair(idx,value))
    }


    val p = stack.pop()
    i = p.first
    v = p.second
    while (stack.isNotEmpty()) {
        val (idx,value) = stack.pop()

        if (value >= v) {
            answer += v * (i - idx)
            i = idx
            v = value
        }

    }

    println(answer + v)
}