import java.util.*

class Solution {
    fun solution(my_string: String): String {
        var result = ""
        val set : HashSet<Char> = hashSetOf()
        for(i in my_string){
            if(!set.contains(i)){
                set.add(i)
                result+=i
            }
        }
        return result
    }
}