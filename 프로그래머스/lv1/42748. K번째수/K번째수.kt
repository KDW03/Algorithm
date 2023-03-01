class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)        
        for((idx, command) in commands.withIndex()){
            // 명령어를 살펴서 주어진 명령된 만큼 자른다.
            val sliceArray = array.sliceArray(command[0]-1 until command[1])
            // 정렬을 한다
            val sortList = sliceArray.sorted()
            // k번째 값을 가져와서 정답 배열에 저장한다
            answer[idx] = sortList[command[2]-1]
        }
        return answer
    }
}
