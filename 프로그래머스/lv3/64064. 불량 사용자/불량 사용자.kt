class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var map: MutableMap<String, MutableSet<String>> = mutableMapOf()

        banned_id.forEach { id ->
            if(map[id] == null) map[id] = mutableSetOf()
            val s = id.replace('*', '.')
            val regex = s.toRegex()
            user_id.forEach {
                if (regex.matches(it)) {
                    map[id]?.add(it)
                }
            }
        }

        val resultSet = mutableSetOf<Set<String>>()
        combination(banned_id, map, setOf(), 0, resultSet)

        return resultSet.size
    }

    fun combination(
        banned_id: Array<String>,
        map: Map<String, Set<String>>,
        set: Set<String>,
        idx: Int,
        resultSet: MutableSet<Set<String>>
    ) {
        if (idx == banned_id.size) {
            resultSet.add(set)
            return
        }

        for (candi in map[banned_id[idx]]!! - set) {
            combination(banned_id, map, set + candi, idx + 1, resultSet)
        }
    }
}
