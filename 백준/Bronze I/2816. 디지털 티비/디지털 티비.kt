fun main() {
    val br = System.`in`.bufferedReader()
    var kbs1Index = -1
    var kbs2Index = -1
    repeat(br.readLine().toInt()) {
        val input = br.readLine()
        if (input == "KBS1") {
            kbs1Index = it
        }
        if (input == "KBS2") {
            kbs2Index = it
        }
    }

    var ans = ""
    if (kbs1Index > kbs2Index) kbs2Index++

    repeat(kbs1Index) {
        ans += "1"
    }
    repeat(kbs1Index) {
        ans += "4"
    }
    repeat(kbs2Index) {
        ans += "1"
    }
    repeat(kbs2Index - 1) {
        ans += "4"
    }

    println(ans)
}