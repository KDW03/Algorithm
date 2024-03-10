fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()
    val sb = StringBuilder()

    // 각 문자 출현 개수로 mapping
    val countMap = n.groupingBy { it }.eachCount()

    // key를 기준으로 내림차순 정렬 후 발현 횟수 만큼 반복해서 sb에 추가
    countMap.toList().sortedByDescending {
        it.first
    }.forEach { (c,v) ->
        repeat(v) {
            sb.append(c)
        }
    }

    println(sb.toString())
}