fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var locationArr = mutableListOf<Int>()
    repeat(br.readLine().toInt()) {
        locationArr.add(br.readLine().toInt())
    }

    var range = (1 .. m)
    var move = 0
    for (location in locationArr) {
        if (location !in range) {
            range = if (range.first < location) {
                move += location - range.last
                (location - m + 1..location)
            } else {
                move += range.first - location
                (location until location + m)
            }
        }
    }
    println(move)
}
