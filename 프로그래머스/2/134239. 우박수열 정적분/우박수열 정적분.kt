class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {

        var nowK = k
        var sums = ArrayList<Double>()
        sums.add(0.0)

        while(nowK != 1) {
            val pre = nowK.toDouble()
            nowK = if(nowK % 2 == 0) nowK / 2 else nowK * 3 + 1
            val current = nowK.toDouble()
            sums.add(((pre + current) / 2) + sums.last())
        }
        
        println(sums.joinToString(" "))

        val n = sums.size - 1
        
        return ranges.map {
            var a = it[0]
            var b = it[1]

            if(a == 0 && b == 0) sums.last()
            else {                
                b = n + b
                if(a !in sums.indices||b !in sums.indices || a > b) -1.0
                else sums[b] - sums[a]
            }
            
        }.toDoubleArray()
    }
}