/*
Exercise 2.
The challenge is to write a minmax function that searches for minimum and maximum values stored in the list of integers.
The search should be performed in one pass over the list. It *has to* be a tail-recursive solution.

Example:
val x = List(-3,10, 90, 89, 12, 5, -5, 12, -16, 9908)
val mm = minmax( x )
// mm contains a tuple of two numbers of which the first one is the minimum value stored in the list, the second is the maximum value.
 */

object Exercise_2 {
  def main(args: Array[String]): Unit = {
    val x = List(-3,10, 90, 89, 12, 5, -5, 12, -16, 9908)
    val mm = minmax( x )

    println(mm)
  }

  @scala.annotation.tailrec
  def minmaxRecursive(list: List[Int], min: Int, max: Int): List[Int] ={
    if(list.isEmpty)  List(min, max)
    else if(list.head > max) minmaxRecursive(list.drop(1), min, list.head)
    else if(list.head < min) minmaxRecursive(list.drop(1), list.head, max)
    else minmaxRecursive(list.drop(1), min, max)
  }

  def minmax(list: List[Int]): List[Int]={
    minmaxRecursive(list, list.head, list.head)
  }
}