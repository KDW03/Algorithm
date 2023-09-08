class Solution {
    fun solution(t: String, p: String): Int {
        val plen = p.length
        var count = 0
                
        for(i in 0 .. t.length - plen) 
            if(t.substring(i until i + plen) <= p) count ++
        
        return count
    }
}