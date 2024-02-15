fun main() {
    val br = System.`in`.bufferedReader()
    val cards = List(5) { br.readLine().split(" ") }.map { it[0] to it[1].toInt() }
    // 동일한 컬러 : 개수 map
    val colors = cards.groupBy { it.first }.mapValues { it.value.size }
    // 동일한 숫자 : 개수 map
    val numbers = cards.groupBy { it.second }.mapValues { it.value.size }


    val sortedNumbers = cards.map { it.second }.sorted()
    val isConsecutive = sortedNumbers.zipWithNext { a, b -> b - a }.all { it == 1 }
    val allSameColor = colors.keys.size == 1

    // 1 => 5장 같은색, 연속 수
    if (allSameColor && isConsecutive) return println(900 + sortedNumbers.last())

    //2 => 4장 같은숫자
    if (numbers.maxBy { it.value }.value == 4) return println(800 + numbers.maxBy { it.value }.key)

    //3 => 3장 같은 숫자, 2장 같은 숫자
    if (numbers.keys.size == 2) return println(700 + numbers.maxBy { it.value }.key * 10 + numbers.minBy { it.value }.key)

    //4 => 5장 카드 색갈 모두 같다면
    if (allSameColor) return println(600 + numbers.maxBy { it.key }.key)

    //5 => 5 연속된 숫자
    if (isConsecutive) return println(500 + numbers.maxBy { it.key }.key)

    //6 => 3장 같은숫자 , 즉 3,1,1
    if (numbers.maxBy { it.value }.value == 3) return println(400 + numbers.maxBy { it.value }.key)

    // 7 => 2,2,1
    if (numbers.keys.size == 3) return println(300 + numbers.filter { it.value == 2 }
        .let { it.maxBy { it.key }.key * 10 + it.minBy { it.key }.key }
    )
    // 8 -> 2,1,1,1
    if (numbers.keys.size == 4) return println(200 + numbers.maxBy { it.value }.key)

    // 9
    return println(100 + numbers.maxBy { it.key }.key)
}