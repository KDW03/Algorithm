class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var map : HashMap<String,Int> = hashMapOf()
        for(i in clothes){
            val clo = i[1]
            val tmp = map[clo]
            if(tmp == null){
                map.put(clo,1)
            }else{
                map.put(clo,tmp+1)
            }
        }
        var sum = 1
        if(map.size == 1){
            for(key in map.keys){
                sum = map[key]!!
            }
        }else{
            for(key in map.keys){
                sum *= (map[key]!!+1)
            }
            sum--
        }  
        return sum
    }
}