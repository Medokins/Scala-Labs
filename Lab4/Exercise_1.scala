/*Exercise 1 (no external help):
  The challenge is to write a replacement for generators (until/to).
  That is functions that create other functions that, when invoked produce a sequence of integers:
  That is how we want to use it:
  val g_1_4 = gen_seq(1, 4) // funciton g_1_4 generates integres from 1 to 4  and then keeps returning 4 i.e. 1 2 3 4 4 4 4 4 4 ....
  val g_0_inf = gen_seq(0, Int.MaxValue)
  val g_7_10 = gen_seq(7, 10)
  for ( i <- 0 until 10 ) {
    println(g_1_4() + " " + g_0_inf() + " " + g_7_10())
}*/

object Exercise_1 {
  def main(args: Array[String]): Unit = {

    val g_1_4 = gen_seq(1,4)
    val g_0_inf = gen_seq(0, Int.MaxValue)
    val g_7_10 = gen_seq(7, 10)

    for ( i <- 0 until 10 ) {
      println(g_1_4() + " " + g_0_inf() + " " + g_7_10())
    }
  }

  def gen_seq(start: Int, end: Int): ()=>Int= {
    var count = -1
    () => {
        count += 1
        if(start + count < end)  count+start else end
      }
    }
}
