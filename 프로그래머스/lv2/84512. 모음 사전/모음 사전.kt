import java.util.*

class Solution {
    
    val stringSet : HashSet<String> = hashSetOf()
    val strArr = arrayOf<String>("A","E","I","O","U")
    
    fun solution(word: String): Int {
        var answer = 0
        dfs("")
        val sortList = stringSet.toList().sorted()
        return sortList.indexOf(word)+1
    }
    
    
    fun dfs(nowStr: String){
        if(nowStr.length == strArr.size) return
        for(i in 0 until 5){
            val tmp = nowStr + strArr[i]
            stringSet.add(tmp)
            dfs(tmp)
        }
    }
    
    
    
}