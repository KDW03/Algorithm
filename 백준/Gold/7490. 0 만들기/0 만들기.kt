val sb = StringBuilder()
val dp = Array(10) {
    ArrayList<String>()
}

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    dp[1].add("1")

    for (i in 2 until 10) {
        for (s in dp[i - 1]) {
            dp[i].add("$s $i")
            dp[i].add("${s}+${i}")
            dp[i].add("${s}-${i}")
        }
    }

    repeat(t) {
        for (s in dp[br.readLine().toInt()]) {
            if (isZero(s)){
                sb.append(s).append("\n")
            }
        }
        sb.append("\n")
    }

    print(sb.toString().trimEnd())
}

fun isZero(it: String) : Boolean {

    val s = it.split(" ").joinToString("")
    var oper = 'n'
    // 이전 결과
    var prePre = ""
    var pre = ""
    var first = true

    for (c in s) {
        when(c) {
            '+','-' -> {
                when(oper) {
                    '+' -> {
                        prePre = ((prePre).toInt() + (pre).toInt()).toString()
                        pre = ""
                        oper = c
                    }
                    '-' -> {
                        prePre = ((prePre).toInt() - (pre).toInt()).toString()
                        pre = ""
                        oper = c
                    }
                    'n' -> {
                        oper = c
                        first = false
                    }
                }
            }
            else -> {
                if (first) {
                    prePre += c
                } else {
                    pre += c
                }
            }
        }
    }


    prePre = when (oper) {
        '+' -> {
            ((prePre).toInt() + (pre).toInt()).toString()
        }
        '-' -> {
            ((prePre).toInt() - (pre).toInt()).toString()
        }
        else -> {
            prePre
        }
    }

    return prePre == "0"
}