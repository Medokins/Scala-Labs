object Exercise_2 {
  def main(args: Array[String]): Unit = {
    val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
    println(a(0))
    println(a(1))
    println(a)
    val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new C(77)) // covariantness
    println(b)
    val d1 = b.replace(0)(new A) // converts to TwistedMonoPair[A]
    println(d1)
    val d2 = b.replace(1)(new A) // replacing 2nd element
    println(d2)
  }
}

class TwistedMonoPair[+T](val obj_1: T, val obj_2: T){
  def replace[U>:T](index: Int)(sample: U) : TwistedMonoPair[U] = {
    if(index == 0) TwistedMonoPair[U](sample, obj_2)
    else TwistedMonoPair[U](obj_1, sample)
  }
  def apply(index: Int): T = {
    if(index == 0) obj_1
    else obj_2
  }
  override def toString() = obj_1.toString + " " + obj_2.toString
}

object TwistedMonoPair{
  def apply[T](arg1: T, arg2: T) = new TwistedMonoPair[T](arg1, arg2)
}

class A{override def toString: String = "A"}
class B( val x: Int) extends A{override def toString: String = "B:"+x.toString}
class C( x: Int) extends B(x){override def toString: String = "C:"+x.toString}