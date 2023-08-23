import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val il = HashSet<Int>()

    val a = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    repeat(a) {
        il.add(st.nextToken().toInt())
    }
    val b = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    val ol = IntArray(b)
    repeat(b) {
        ol[it] = (st.nextToken().toInt())
    }
    ol.forEach {
        val tmp = if (il.contains(it)) "1\n" else "0\n"
        bw.write(tmp)
    }
    bw.flush()
}
