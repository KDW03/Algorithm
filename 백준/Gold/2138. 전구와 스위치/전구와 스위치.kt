fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val current = br.readLine().map { it.digitToInt() }.toIntArray()
    val target = br.readLine().map { it.digitToInt() }.toIntArray()
    println(minimumSwitches(n, current, target))
}

fun minimumSwitches(n: Int, current: IntArray, target: IntArray): Int {
    val pressFirst = current.copyOf()
    pressFirst[0] = pressFirst[0] xor 1
    pressFirst[1] = pressFirst[1] xor 1

    val notPressFirst = current.copyOf()

    val pressCount1 = countSwitches(n, pressFirst, target, 1)
    val pressCount2 = countSwitches(n, notPressFirst, target, 0)

    return if (pressCount1 == -1 || pressCount2 == -1) {
        maxOf(pressCount1, pressCount2)
    } else {
        minOf(pressCount1 + 1, pressCount2)
    }
}

fun countSwitches(n: Int, current: IntArray, target: IntArray, initialPresses: Int): Int {
    var presses = initialPresses
    for (i in 1 until n) {
        if (current[i - 1] != target[i - 1]) {
            presses++
            current[i - 1] = current[i - 1] xor 1
            current[i] = current[i] xor 1
            if (i < n - 1) current[i + 1] = current[i + 1] xor 1
        }
    }

    return if (current[n - 1] == target[n - 1]) presses else -1
}