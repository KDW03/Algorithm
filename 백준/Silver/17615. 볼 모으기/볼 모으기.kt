fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val str = br.readLine().map { it == 'R' }

    val colorCountMap = str.groupingBy { it }.eachCount()

    if (colorCountMap.keys.size == 1) {
        println(0)
        return
    }

    val frontStartColor = str.first()
    val backStartColor = str.last()


    // 옮길필요없는 왼쪽 시작 공 개수
    val fi = str.indexOfFirst { it == !frontStartColor }
    // 옮길필요없는 오른쪽 시작 공 개수
    val bi = str.size - 1 - str.indexOfLast { it == !backStartColor }

    println(
        minOf(
            // firstColor 왼쪽으로 이동 하는 횟수
            colorCountMap[frontStartColor]!! - fi,
            // backColor 오른쪽으로 이동 하는 횟수
            colorCountMap[backStartColor]!! - bi,
            // firstColor 아닌 컬러공 왼쪽 이동
            colorCountMap[!frontStartColor]!!,
            // backColor 아닌 컬러공 오른쪽 이동
            colorCountMap[!backStartColor]!!
        )
    )
}