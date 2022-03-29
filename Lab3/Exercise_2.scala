object Exercise_2 {
  def main(args: Array[String]): Unit={
    <("Hello world")
    <(3)("Hello world") // prints the string proceeding it by 3 spaces

    println(invokeAndAccumulate(3, (x: Int) => 2+x ,  4)) // no recursion needed, 3 is an initial value of arg passed to function, 4 number of repetitions
    println(invokeAndAccumulate(2, (x: Int) => x*x))
    println(max(4)(5))
  }

  def <(spaces: Int)(s: String): Unit ={
    println(" "*spaces + s)
  }

  def <(str: String): Unit ={
    println(str)
  }

  def invokeAndAccumulate(num: Int, function: Int => Int, repeat: Int=1): Int={
    if(repeat == 0) return num
    invokeAndAccumulate(function(num), function, repeat - 1)
  }

  def max(x: Int)(y: Int): Int ={
    if(x > y) x
    else y
  }
}
