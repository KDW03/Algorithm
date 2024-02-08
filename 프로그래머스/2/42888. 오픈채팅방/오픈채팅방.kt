class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        
        val userIdNameMap : HashMap<String,String> = hashMapOf()
        
        // n 
        record.forEach {
            val input = it.split(" ")
            val action = input[0]
            if(action == "Enter" || action == "Change") {
                  userIdNameMap[input[1]] = input[2]
            }
        }
        
        // 2n
        return record.map {
            val input = it.split(" ")
            var lastName = userIdNameMap[input[1]]
            when(input[0]) {
                "Enter" -> {
                    "${lastName}님이 들어왔습니다."
                }
                "Leave" -> {
                    "${lastName}님이 나갔습니다."
                }
                else -> {
                    ""
                }
            }
        }.filter { it != "" }.toTypedArray()
        
    }
}