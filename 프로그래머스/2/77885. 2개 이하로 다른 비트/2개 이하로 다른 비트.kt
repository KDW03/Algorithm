class Solution {
    fun solution(numbers: LongArray): LongArray {
        return numbers.map { num ->
            // 이진수로 변환
            val binary = num.toString(2).toCharArray()
            // 끝 0의 인덱스를 찾고
            var zeroIdx = binary.indexOfLast { it == '0' }

            // 찾았다면 그것을 1로 변경 후 변경점과 가장 근접한 뒤에 1을 0으로 변경
            if (zeroIdx != -1) {
                binary[zeroIdx] = '1'
                zeroIdx++
                while(zeroIdx < binary.size) {
                    if(binary[zeroIdx] == '1') {
                        binary[zeroIdx] = '0'
                        break
                    }
                    zeroIdx++
                }
                binary.joinToString("").toLong(2)
            } else {
                ("10" + binary.drop(1).joinToString("")).toLong(2)
            }
        }.toLongArray()
    }
}