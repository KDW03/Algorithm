fun main() {
    val br = System.`in`.bufferedReader()
    val (H, W) = br.readLine().split(" ").map { it.toInt() }
    val sky = Array(H) { br.readLine().toCharArray().map { if (it == 'c') 0 else -1 }.toIntArray() }
    sky.forEach { v ->
        for (y in 1 until v.size) {
            if (v[y] != 0 && v[y - 1] >= 0) {
                v[y] = v[y - 1] + 1
            }
        }
        println(v.joinToString(" "))
    }
}