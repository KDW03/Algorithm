class Solution {
    fun solution(s: String): IntArray {
        var r = s 
        var count = 1
        var zeroCount = 0
        
        while(true){
            var rs = r.length
            r = r.filter{ it != '0' }
            zeroCount += rs - r.length
            r = r.length.toString(2)
            if(r == "1") break 
            count++
        }        
        
        return intArrayOf(count,zeroCount)
    }
}