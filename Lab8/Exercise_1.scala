/*
Exercise 1

In this exercise the goal is to write a a generic container that caches function calls.
That is, it should be constructed with the function and can be used instead of that function.
However repeated calls with the same argument should not actually cause underlying function invocation, rather the
result from the cache should be used.
Obviously it should be a generic because we want it to work for arbitrary functions (of single argument though).
Internally you need to use mutable Map container.
 */

object Exercise_1 {
  def main(args: Array[String]): Unit = {

    def len(s: String): Int = {
      println("Calculating len of:" + s); s.length
    }

    len("Hello")
    len("There")

    val mlen = new Memo(len _)
    mlen("a") // call
    mlen("a") // no call
    mlen("xyz") // do call
    mlen("dhgf") //call
    mlen("dhgf") // no call
    mlen("dhgf") // no call

    def repr(x: Int): String = {
      println("string repr of " + x.toString); x.toString
    }

    val mrepr = new Memo(repr(_))
    mrepr(6)
    mrepr(56)
    mrepr(6) // should not happen
  }
}

class Memo[T, R](val fun: T => R){
  var memoryArray = Map[T,R]()
  def apply(arg: T): R = {
    if(!memoryArray.contains(arg)){
      memoryArray = memoryArray ++ Map[T,R](arg -> fun(arg))
      memoryArray(arg)
    }
    else memoryArray(arg)
  }
}
