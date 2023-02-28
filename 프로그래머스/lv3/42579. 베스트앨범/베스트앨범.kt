import java.util.*


data class Music(val playCount : Int, val index : Int)

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer : MutableList<Int> = mutableListOf()
        
        val map : HashMap<String, MutableList<Music>> = hashMapOf()
        val arr : ArrayList<Pair<String,Int>> = arrayListOf()
        for(i in 0 until genres.size){
            val genre = genres[i]
            if(!map.keys.contains(genre))
                map[genre] = mutableListOf()     
            map[genre]!!.add(Music(plays[i],i))                
        }
        
        for((key,value) in map){
            map[key] = value.sortedBy{
                it.index
            }.sortedByDescending{
                it.playCount
            }.toMutableList()
            arr.add(Pair(key,value.sumOf{it.playCount}))
        }
        
        arr.sortedByDescending{
            it.second
        }.forEach{
            val tmp = map[it.first]!!
            answer.add(tmp[0].index)
            if(tmp.size >= 2)
                answer.add(tmp[1].index)
        }
        return answer.toIntArray()
    }
}