import java.awt.Point

/*In this exercise we have class that holds a description of the point of coordinates x,y,z.
class Point( val Double: x, val Double: y, val Doube: z)....
We want to make such points comparable, that we can tell that one is smaller than other.
Of course the comparison make sense only in 1D, else it is arbitrary, right?
To collapse the 3 dimentions we'll use the distance to (0,0,0) in comparisons.
Your goal is to define trait that, when mixed with the Point will also allow mixing
the Ordered trait with it thus facilitate comparisons of points in 3D.*/

import scala.math._

object Exercise_2 {
  def main(args: Array[String]): Unit = {
    class OrdredPoint(x: Double, y: Double, z: Double) extends Point(x,y,z) with Dist with Ordered[Dist]
    val oPointA = new OrdredPoint(9, 0, 2)
    val oPointB = new OrdredPoint(3, 2, 4)
    print("A < B", oPointA < oPointB)
    print("A < A", oPointA < oPointA)
    print("A == A", oPointA == oPointA)
    print("A != A", oPointA != oPointA)
    print("A == B", oPointA < oPointB)
  }
}

class Point(val x: Double, val y: Double, val z: Double){
  def distance(x: Double, y: Double, z: Double): Double = math.sqrt(x*x + y*y + z*z)
}

trait Dist extends Point{
  def compare(other: Dist): Int = {
    signum(this.distance(this.x, this.y, this.z) - other.distance(other.x, other.y, other.z)).toInt
  }
}