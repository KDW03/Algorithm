class Solution {

    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {

        val map = name.mapIndexed { index, name ->
            Pair(name, yearning[index])
        }.toMap()

        return photo.map { persons ->
            persons.sumOf { person -> if (map.contains(person)) map[person]!! else 0 }
        }.toIntArray()
        
    }
}