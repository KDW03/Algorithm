fun main() {
    val br = System.`in`.bufferedReader()
    val arr = br.readLine().map { it.digitToInt() }.sortedDescending().toIntArray()

    if (arr.last() != 0) {
        println(-1)
        return
    }

    // 30의 배수는 3의 배수이고 10의 배수이어야 함

    // 10의 배수는 0이 하나라도 포함되어 있으면 충족

    // 3의 배수는 dn * (10^n) + dn-1 * 10 ^ (n - 1) ...
    // 10의 거듭제곱을 3으로 나누면 항상 1임

    // 즉 d % 3 = (dn % 3 + dn-1 % 3 ...) % 3 으로 생각가능

    // 각 자리수 값 % 3의 합이 0이면 d는 3의 배수라고 할 수 있음
    val answer = if (arr.sumOf { it % 3 } % 3 == 0) arr.joinToString("") else -1
    println(answer)
}