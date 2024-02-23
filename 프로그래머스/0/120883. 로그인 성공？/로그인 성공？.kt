class Solution {
    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String {
        
        val dbMap = db.map {
            it[0] to it[1]
        }.toMap()

        
        val pw = dbMap[id_pw[0]]
        return if(pw == null) "fail"
        else {
            if(pw == id_pw[1]) "login"
            else "wrong pw"
        }
        
    }
}