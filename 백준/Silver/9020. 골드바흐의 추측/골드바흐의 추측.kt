import kotlin.math.sqrt

var decimalArr: BooleanArray = BooleanArray(10000 + 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    initDecimal()

    for (i in 0 until n) {
        val number = br.readLine().toInt()
        for (num in number / 2 downTo 1) {
            if (decimalArr[num] && decimalArr[number-num]){
                sb.append("$num ${number-num}").append("\n")
                break
            }
        }
        // 절반 부터 하나씩 감소해가며 소수인지 판별
        // list로 한다면 절반에 가까운 값을 찾아야하는데 이게 더 오래 걸릴듯?
    }
    print(sb.toString())
}

fun initDecimal() {
    decimalArr[2] = true // 2는 소수
    for (i in 3 until decimalArr.size step 2) {
        //홀수만 소수 판별
        if (isDecimal(i)) {
            decimalArr[i] = true
        }
    }
}

fun isDecimal(n: Int): Boolean {
    // 소수 판별 알고리즘
    // sqrt(n) 까지
    // 그 보다 작은 소수로 나눠보면서
    // 판별
    for (i in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (decimalArr[i] && n % i == 0) {
            // 소수이고 나눠 진다면
            return false
        }
    }
    return true
}

