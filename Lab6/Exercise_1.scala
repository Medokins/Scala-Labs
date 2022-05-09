/*
 The goal of this exercise is to write a functional class MapPoint
 and non-functional class Route
 The functionality for the class MapPoint is to contain
 the name of the point and its geographical coordinates.
 IMPORTANT the - "operator"/distanceTo should just produce distance of type Double (say in km - but the details of the comptation are completely irrelevant).
 */

object Exercise_1 {
  def main(args: Array[String]): Unit = {
    val krk = MapPoint( "Krakow", 50.061389, 19.938333 );
    println( krk );
    val nyc = MapPoint( "NYC", 40.7127, -74.0059 );
    println( nyc );
    val porto = MapPoint( "Porto", 41.162142, -8.621953 );
    val irkutsk = MapPoint( "Irkutsk",  52.283333, 104.283333 );
    println( irkutsk );

    println( porto - irkutsk )
    println( krk - irkutsk )
    println( krk.distanceTo(porto) )

    val r = Route(krk, nyc, porto)
    println( r );
    r.addStop( porto.move( 1, 1 ) )
    r.addStop( irkutsk )
    println( r ) // 5 stops trip should be printed here
  }
}

class MapPoint(val name: String, val x: Double, val y: Double){
  override def toString: String = {
    val SN = if (x < 0) "S" else "N"
    val WE = if (y < 0) "W" else "E"
    name + " " + Math.abs(x) + SN + " " + Math.abs(y) + WE
  }
  def -(city: MapPoint): Double = distanceTo(city)
  def distanceTo(city: MapPoint): Double = Math.sqrt(Math.pow(city.x - x, 2) + Math.pow(city.y - y, 2))
  def move(x_move: Double, y_move: Double) = new MapPoint(name, x + x_move, y + y_move)
}

object MapPoint {
  def apply(name: String, x: Double, y: Double) = new MapPoint(name, x, y)
}

class Route(val city_1: MapPoint, val city_2: MapPoint, val city_3: MapPoint) {
  var stops = List(city_1, city_2, city_3)
  override def toString: String = {
    var result = stops.head.toString()
    for (i <- stops.tail) result += " -> " + i.toString()
    result
  }
  def addStop(nextStop: MapPoint): Unit = stops = nextStop::stops
}
object Route {
  def apply(x: MapPoint, y: MapPoint, z: MapPoint) = new Route(x,y,z)
}