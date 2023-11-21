fun main() {
    val br = System.`in`.bufferedReader()
    val nm = br.readLine().split(" ").map { it.toInt() }
    val n = nm[0]
    val m = nm[1]
    val ramparr = IntArray(m + 1) { 0 }
    val switchInfoList : Array<List<Int>> = Array(n) { arrayListOf() }

    repeat(n) {
        val switchInfo = br.readLine().split(" ").map{ i -> i.toInt() }.drop(1)
        switchInfoList[it] = switchInfo
        switchInfo.forEach { ramp ->
            ramparr[ramp] = ramparr[ramp] + 1
        }
    }

    var answer = 0
    outer@for(switchInfo in switchInfoList) {
        for(connectRamp in switchInfo) {
            if(ramparr[connectRamp] <= 1) continue@outer
        }
        answer = 1
        break@outer
    }

    println(answer)


}