fun main() {
    val br = System.`in`.bufferedReader()
    // 사람 수 , 파티 수
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 첫 번째는 수
    val knownNum = br.readLine().split(" ").map { it.toInt() }.run {
        slice(1..this[0])
    }.toMutableSet()
    val hashMap = HashMap<Int, ArrayList<Int>>()
    val strAl = ArrayList<String>()
    repeat(m) {
        val party = br.readLine()
        strAl.add(party)
        party.split(" ").let {
            if (it.size > 2) {
                it.map { it.toInt() }.let {
                    hashMap[it[1]] = (hashMap[it[1]] ?: arrayListOf()).apply {
                        addAll(it.slice(1..it[0]))
                    }
                }
            }
        }
    }

    while (true) {
        var flag = false
        outer@for (map in hashMap.entries) {
            for (it in map.value) {
                if (knownNum.contains(it)) {
                    //만약 포함이 되어 있다면
                    knownNum.addAll(map.value)
                    hashMap.remove(map.key)
                    flag = true
                    break@outer
                }
            }
        }
        if (flag){
            continue
        }else{
            break
        }
    }

    var count = 0
    outer@ for (party in strAl) {
        var tmp = party.split(" ").map { it.toInt() }.run {
            slice(1..this[0])
        }
        for (num in tmp) {
            if (knownNum.contains(num)) {
                continue@outer
            }
        }
        count++
    }
    println(count)
}
