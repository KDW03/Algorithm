class Solution {
    fun solution(new_id: String): String = CheckLogic.checkAll(new_id)
}
object CheckLogic {
    fun checkAll(str: String): String = str.check1().check2().check3().check4().check5().check6().check7()
    private fun String.check1(): String = lowercase()
    private fun String.check2(): String = filter { it.isDigit() || it.isLowerCase() || it == '-' || it == '_' || it == '.' }
    private fun String.check3(): String = replace(Regex("\\.{2,}"), ".")
    private fun String.check4(): String = trimStart('.').trimEnd('.')
    private fun String.check5(): String = if (isEmpty()) "a" else this
    private fun String.check6(): String = if (length >= 16) take(15).check4() else this
    private fun String.check7(): String = if (length > 2) this else this + last().toString().repeat(3 - length)
}

