fun main() {
    val br = System.`in`.bufferedReader()
    val (h, w, x, y) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(h + x) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val ansArr = Array(h) { IntArray(w) }

    // x 만큼 해당 열 채워주기
    for (ax in 0 until x) {
        for (ay in 0 until w) {
            ansArr[ax][ay] = arr[ax][ay]
        }
    }

    // x + 1 부터 y만큼 채워주기
    for (ax in x until h) {
        for (ay in 0 until y) {
            ansArr[ax][ay] = arr[ax][ay]
        }
    }

    // 남은 y 부분
    for (ax in x until h) {
        for (ay in y until w) {
            ansArr[ax][ay] = arr[ax][ay] - ansArr[ax - x][ay - y]
        }
    }

    val sb = StringBuilder()

    ansArr.forEach {
        sb.append(it.joinToString(" ")).append("\n")
    }

    println(sb.toString())
}