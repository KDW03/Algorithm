val sb = StringBuilder()

fun main() {

    //49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택
    val br = System.`in`.bufferedReader()

    while (true) {
        val input = br.readLine().split(" ").map { it.toInt() }
        if (input[0] == 0) break
        combination(input.drop(1))
        sb.append("\n")
    }

    println(sb.toString())

}

fun combination(list: List<Int>, idx: Int = 0, new: List<Int> = listOf()) {

    // 6개 뽑았다면
    if (new.size >= 6) {
        sb.append(new.joinToString(" ")).append("\n")
        return
    }

    // 인덱스를 초과했다면 종료
    if (idx == list.size) return

    // idx 위치의 값을 뽑았을때
    combination(list, idx + 1, new + list[idx])
    // idx위치 거를 안 뽑았을 때
    combination(list, idx + 1, new)
}
