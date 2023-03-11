fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val arrayList = ArrayList<Int>()
    repeat(n) {
        val cmd = br.readLine().split(" ")
        when (cmd[0]) {
            "push_front" -> arrayList.add(0, cmd[1].toInt())
            "push_back" -> arrayList.add(cmd[1].toInt())
            "pop_front" -> sb.append(if (isEmpty(arrayList)) -1 else arrayList.removeFirst()).append("\n")
            "pop_back" -> sb.append(if (isEmpty(arrayList)) -1 else arrayList.removeLast()).append("\n")
            "size" -> sb.append(arrayList.size).append("\n")
            "empty" -> sb.append(if (isEmpty(arrayList)) 1 else 0).append("\n")
            "front" -> sb.append(if (isEmpty(arrayList)) -1 else arrayList.first()).append("\n")
            "back" -> sb.append(if (isEmpty(arrayList)) -1 else arrayList.last()).append("\n")
        }
    }
    print(sb.toString())
}

fun isEmpty(arrayList: ArrayList<Int>): Boolean = arrayList.size == 0