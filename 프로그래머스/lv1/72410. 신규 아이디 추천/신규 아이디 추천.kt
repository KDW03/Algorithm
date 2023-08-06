
class Solution {
    fun solution(new_id: String): String = if (CheckLogicImpl.preCheck(new_id)) new_id else CheckLogicImpl.checkAll(new_id)
}

object CheckLogicImpl : CheckID {

    override fun preCheck(str: String): Boolean =
        str.length in (3..15) && str.all { it.isDigit() || it.isLowerCase() || it == '-' || it == '_' || it == '.' } && str.first() != '.' && str.last() != '.' && !str.contains(
            ".."
        )

    override fun checkAll(str: String): String = str.check1().check2().check3().check4().check5().check6().check7()

    override fun String.check1(): String = lowercase()

    override fun String.check2(): String =
        filter { it.isDigit() || it.isLowerCase() || it == '-' || it == '_' || it == '.' }

    // 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
     override fun String.check3(): String = replace(Regex("\\.{2,}"), ".")


    // 마침표(.)가 처음이나 끝에 위치한다면 제거
     override fun String.check4(): String {
        var temp = this
        if (temp.isNotBlank() && temp.first() == '.') temp = temp.substring(1, temp.length)
        if (temp.isNotBlank() && temp.last() == '.') temp = temp.substring(0,temp.length - 1)
        return temp
    }
    // 빈 문자열이라면, new_id에 "a"를 대입
    override fun String.check5(): String = if (trim().isBlank()) "a" else this

    // 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    override fun String.check6(): String = if (length >= 16) substring(0,15).check4() else this

    // new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
    override fun String.check7(): String = run { if (length > 2) this else this + last().toString().repeat(3 - length) }
}


interface CheckID {
    fun preCheck(str: String): Boolean
    fun checkAll(str: String): String
    fun String.check1(): String
    fun String.check2(): String
    fun String.check3(): String
    fun String.check4(): String
    fun String.check5(): String
    fun String.check6(): String
    fun String.check7(): String
}