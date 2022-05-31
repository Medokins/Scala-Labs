/*
We have functions Int => Int that in addition to the "job" also print to the screen.
def pow(x: Int) = { println("pow"+x); x*x }
def d2(x: Int) = { println("d2"+x); x*2 }
The goal is to take control over this side effect. We'll modify the functions to produce tuple, result, string:
def powT(x: Int) = { ("pow:"+x.toString, x*x) }
def d2T(x: Int) = { ("d2:"+x.toString; x*2) }
Now the challenge is:
Write function composeII that will take any two functions of the first kind and compose them.
I.e.
val c = composeII( pow, d2)  // c is a function Int => Int that effectively does pow(d2(arg))
Write composeTT that does the same with the second kind (those returning (String, Int) tuples)
and composte them as composeII. During the compositeion the String shoudl be concatenated.
I.e. val c = composeTT( powT, d2T );
c(3) should produce: ("d2:3 -> pow:6", 36)
composing it further:
val d = composeTT(c, powT)
d(5) // should produce ("d2:5 -> pow:10 -> pow:100", 10000)
and so on....
 */

object Exercise_2 {
  def main(args: Array[String]):Unit = {
    val c = composeII(pow, d2)
    println(c(3))
    val d = composeTT(powT, d2T)
    println(d(3))
    val e = composeTT(d, powT)
    println(e(5))
  }

  def pow(x: Int): Int = { println("pow"+x); x*x }
  def d2(x: Int): Int = { println("d2"+x); x*2 }
  def powT(x: Int): (String, Int) = { ("pow:"+x.toString, x*x) }
  def d2T(x: Int): (String, Int) = { ("d2:"+x.toString, x*2) }

  def composeII(function1: Int => Int, function2: Int => Int): Int => Int = {
    x:Int => function1(function2(x))
  }

  def composeTT(function1: Int => (String, Int), function2: Int => (String, Int)): Int => (String, Int) = {
    x:Int => {
      val a = function2(x)._1
      val b = function2(x)._2
      (a + " -> " + function1(b)._1, function1(b)._2)
    }
  }
}
