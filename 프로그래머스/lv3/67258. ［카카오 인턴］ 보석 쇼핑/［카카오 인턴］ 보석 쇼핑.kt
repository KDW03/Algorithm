class Solution {
    fun solution(gems: Array<String>): IntArray {
        val totalGems = gems.toSet().size
        val gemMap = mutableMapOf<String,Int>()
        var start = 0
        var end = 0
        var minStart = 0
        var length = Int.MAX_VALUE

        while(end < gems.size) {
            
            // 모든 원소를 포함할때 까지 end를 증가시킴
            gemMap[gems[end]] = gemMap.getOrDefault(gems[end], 0) + 1
            end++
            
            // 모두 포함하지않을 때 까지 start 증가
            while (gemMap.size == totalGems) {
                
                // 현재 최소라면 최소거리 갱신
                if(end - start < length) {
                    length = end - start
                    minStart = start
                    if(end - start == totalGems) break 
                }
                
            
                // start 위치에 있는거 개수하나 빼줌
                gemMap[gems[start]] = gemMap[gems[start]]!! - 1
                
                // 0개 있다면 없애줌
                if (gemMap[gems[start]]!! == 0) {
                    gemMap.remove(gems[start])
                }
                
                // start 증가
                start++
            }
            
        }
        
        return intArrayOf(minStart + 1, minStart + length)
    }
}