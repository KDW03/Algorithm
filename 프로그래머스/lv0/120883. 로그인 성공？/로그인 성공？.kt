import java.util.*

class Solution {
    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String {
        val map : HashMap<String,String> = HashMap()
        for(i in db){
            map.put(i[0],i[1])
        }
        val id = id_pw[0]
        val pw = id_pw[1]
        
        val response = map[id] 
        if(response == null) return "fail"
        if(response != pw) return "wrong pw"
        return "login"
    }
}