class Solution {
    fun solution(s: String): IntArray {
        val map : HashMap<Int,Int> = hashMapOf()
        var num = ""
        
        s.forEach { c ->
            if(c.isDigit()) {
                num += c    
            }else{
                if(!num.isBlank()) {
                    map[num.toInt()] = map.getOrDefault(num.toInt(),0) + 1
                    num = ""
                }
            }
        }
        
        return map.toList().sortedByDescending { it.second }.map{ it.first }.toIntArray()
    }
}