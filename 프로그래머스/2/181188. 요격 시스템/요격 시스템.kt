class Solution {
    fun solution(targets: Array<IntArray>): Int {
        
        val st = targets.sortedWith(
            compareBy<IntArray>{ it[0] }.thenBy { it[1] }
        )
        
        var rocketCount = 1
        var nowEndRange = st.first()[1]
        for(target in st.drop(1)) {
            val start = target[0]
            // 현재 start가 nowEndRange보다 크거나 같다면 새로운 미사일로 요격해야함
            if(start >= nowEndRange) {
                nowEndRange = target[1]
                rocketCount++
            } else {
                // 포함된다면 endRange 최솟값으로 갱신
                nowEndRange = minOf(nowEndRange,target[1])
            }
        }
        
        return rocketCount
        
    }
}