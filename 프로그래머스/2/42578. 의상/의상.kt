class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val hashMap = hashMapOf<String,Int>()
        
        clothes.forEach {
            val type = it[1]
            hashMap[type] = hashMap.getOrDefault(type,0) + 1
        }
        
        return hashMap.values.fold(1) { pre, now -> 
            pre * (now + 1)
        } - 1
    }
}