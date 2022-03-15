import scala.util.Random


object Pi {
  def main(args: Array[String]): Unit = {
    print(getPi(1000000))
  }

  def generatePoint() : Array[Double] = {
    val generator = new Random()
    val point = for(i <- 0 until 2) yield generator.nextDouble()
    return point.toArray
  }

  def generateSequence(n : Int): Array[Array[Double]] = {
    val sequence = for(i <- 0 until n) yield generatePoint()
    return sequence.toArray
  }

  def check(arr: Array[Double]): Boolean = {
    if(Math.sqrt(Math.pow(arr(0), 2) + Math.pow(arr(1), 2)) <= 1) return true else return false
  }

  def countPoints(arr: Array[Array[Double]]): Double = {
    val x = for{i <- 0 until arr.length if check(arr(i))} yield 1
    return x.toList.length
  }

  def getPi(n: Int) : Double = {
    return 4.0 * (countPoints(generateSequence(n)) / n)
  }
}