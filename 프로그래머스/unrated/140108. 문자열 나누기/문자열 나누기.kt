class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var count = 0
        
        var fw : Char? = null
        var fcount = 0
        var dcount = 0
        
        for(i in 0 until s.length) {
            
            if(fw == null){
                fw = s[i]
                fcount = 1
                continue
            }
            
            if(fw == s[i]) {
                fcount++
            }else{
                dcount++
            }
            
            if(fcount == dcount){
                fw = null
                count++
                fcount = 0
                dcount = 0
            }
        }
        
        if(fcount != dcount) {
            count++
        }
        
        return count
    }
}