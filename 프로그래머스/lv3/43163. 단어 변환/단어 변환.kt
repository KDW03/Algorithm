import java.util.*

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        if(!words.contains(target)) return 0
        val visited = BooleanArray(words.size)
        return dfs(begin, target, words, visited, 0)
    }
    
    fun dfs(begin: String , target: String , words : Array<String>,visited : BooleanArray,count : Int) : Int {
        var min = Int.MAX_VALUE
        visited[words.size - 1] = false
        if(begin == target) 
            return count
        if(words.size == count) return Int.MAX_VALUE
        for((idx,word) in words.withIndex()){
                if(visited[idx]) continue
                var diffCount = 0
                for(i in word.indices){
                    if(diffCount >= 2) break
                    if(word[i] != begin[i]) {
                        diffCount++
                    }
                }
                if(diffCount == 1){
                    visited[idx] = true
                    min = minOf(min,dfs(word,target,words,visited,count+1))
                }
            }
        return min
    }
}