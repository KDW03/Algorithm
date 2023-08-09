import java.util.*

val map = mapOf(
    ']' to '[' ,
    ')' to '(' ,
    '}' to '{' 
)

class Solution {
    fun solution(s: String): Int {
        var answer = 0
    
        if(s.length % 2 != 0) return 0
        for((k,v) in map)
            if(s.count{ it == k } != s.count { it == v } ) return 0
        
        for(i in 0 until s.length) {    
            val t = s.substring(i) + s.substring(0 until i)
            if(isCollect(t)) {
                answer++
            }
        }
        
        return answer
    }
}


fun isCollect(s : String) : Boolean {
    var tmp = s
    var flag = true
    val stack : Stack<Char> = Stack()
    for(i in 0 until s.length) {
        val t = s[i]
        if(map.keys.contains(t)) {
            if(stack.isEmpty() || stack.pop() != map[t]) {
                flag = false
                break
            }
        } else {
            stack.push(t)
        }        
    }
    return flag
}