data class Node(val num: Int) {
    var left: Node? = null
    var right: Node? = null
}

fun main() {
    val br = System.`in`.bufferedReader()
    var root: Node? = null

    while (true) {
        val line = br.readLine() ?: break
        val num = line.toIntOrNull() ?: break
        root = makeTree(root, num)
    }
    val sb = StringBuilder()
    printBackFirst(root,sb)
    println(sb.toString())
}

fun printBackFirst(root: Node?, sb : StringBuilder) {
    if (root == null) return
    printBackFirst(root.left,sb)
    printBackFirst(root.right,sb)
    sb.append(root.num).append("\n")
}


fun makeTree(root: Node?, num: Int): Node {
    root ?: return Node(num)

    if (num < root.num) {
        root.left = makeTree(root.left, num)
    } else {
        root.right = makeTree(root.right, num)
    }

    return root
}