/*Exercise 1:
The challenge is to write tile recursive function that merges list of lists by picking elements in such order:
el 0 of list 0, el 0 of list 1, el 0 of list 2 ... el 1 of list 0, el 1 of list 1, ....
The merging should stop if any list end is reached:

Example:

  val lA = List(1,2,3,4)
  val lB = List(10,9,8,7)
  val lC = List(-1,-2,1) // has only 3 elements
  val lD = List(100,90,80,70,60,50) // has more elements

  val output = merge( List(lA,lB,lC,lD) )
  println(output.mkString(", "))
  result: 1, 10, -1, 100, 2, 9, -2, 90, 3, 8, 1, 80*/

object Exercise_1 {
  def main(args: Array[String]): Unit = {
    val lA = List(1, 2, 3, 4)
    val lB = List(10, 9, 8, 7)
    val lC = List(-1, -2, 1) // has only 3 elements
    val lD = List(100, 90, 80, 70, 60, 50) // has more elements

    val output = merge(List(lA, lB, lC, lD))
    println(output.mkString(", "))
  }

  @scala.annotation.tailrec
  def checkEmpty(buffer: List[List[Int]]): Boolean = {
    if (buffer.isEmpty) false
    else if (buffer.head.isEmpty) true
    else checkEmpty(buffer.drop(1))
  }

  @scala.annotation.tailrec
  def dropHeads(buffer: List[List[Int]], newList: List[List[Int]]): List[List[Int]] = {
    if (buffer.isEmpty) newList
    else dropHeads(buffer.drop(1), newList :+ buffer.head.drop(1))
  }

  @scala.annotation.tailrec
  def getheads(buffer: List[List[Int]], mergedList: List[Int]): List[Int] = {
    if (buffer.isEmpty) mergedList
    else getheads(buffer.tail, mergedList :+ buffer.head.head)
  }

  @scala.annotation.tailrec
  def mergRec(list: List[List[Int]], temp: List[Int]): List[Int] = {
    if (checkEmpty(list)) temp
    else mergRec(dropHeads(list, List[List[Int]]()), temp ++ getheads(list, List.empty))
  }

  def merge(list: List[List[Int]]): List[Int] = {
    mergRec(list, List[Int]())
  }
}
