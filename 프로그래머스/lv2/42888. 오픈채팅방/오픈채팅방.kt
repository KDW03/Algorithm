

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val map : HashMap<String,String> = hashMapOf()
        return record.map {
            val t = it.split(" ")
            val act = Act.valueOf(t[0])
            val id = t[1]
            when(act){
                Act.Enter -> {
                    val name = t[2]
                    map[id] = name
                    "${id}님이 ${act.text}"
                }

                Act.Leave -> {
                    "${id}님이 ${act.text}"
                }

                Act.Change -> {
                    val name = t[2]
                    map[id] = name
                    ""
                }
            }
        }.filter{ it != "" }.map {
            val id = it.split("님이 ")[0]
            it.replace(id,map[id]!!)
        }.toTypedArray()
    }
}

enum class Act(val text : String){
    Enter("들어왔습니다."),
    Leave("나갔습니다."),
    Change("바꿨습니다.")
}