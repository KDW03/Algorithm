import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val prime = BooleanArray(1000001) { true }
    prime[1] = false

    // 홀수만 prime 계산
    for (i in 3..sqrt(prime.size.toDouble()).toInt() step 2) {
        if (prime[i]) {
            for (j in i * i until prime.size step 2*i) prime[j] = false
        }
    }
    
    outer@ while (true) {
        val num = br.readLine().toInt()
        if (num == 0) break

        // 홀수만 검사
        for (i in 3 until num step 2) {
            // 둘다 홀수이면서 소수라면
            if (prime[i] && prime[num - i]) {
                sb.append("$num = $i + ${num - i}").append("\n")
                continue@outer
            }
        }

        sb.append("Goldbach's conjecture is wrong.").append("\n")
    }

    print(sb.toString())
}
