class Solution {

    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {

        val map = name.zip(yearning.toTypedArray()).toMap()
        
        return photo.map { persons ->
            persons.sumOf { person -> map[person] ?: 0 }
        }.toIntArray()
        
    }
}