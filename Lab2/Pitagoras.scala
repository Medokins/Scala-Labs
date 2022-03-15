object Pitagoras {
  def main(args: Array[String]) : Unit = {
    print(findMissing(args) + " = " + calculate(findMissing(args), sliceArray(args)))
  }

  def findMissing(arr: Array[String]) : String = {
    if(!arr.contains("c")) return "c"
    else if(!arr.contains("b")) return "b"
    else return "a"
  }

  def sliceArray(arr: Array[String]) : Array[Array[String]] = {
    val sequence = for(i <- 0 until 2) yield Array(arr(2 * i), arr(2 * i + 1))
    return sequence.toArray
  }

  def calculate(missing : String, arr: Array[Array[String]]) : Double = {
    if(missing == "a"){
      if(arr(0).contains("b")) return (Math.sqrt(Math.pow(arr(1)(0).toDouble, 2) - Math.pow(arr(0)(0).toDouble, 2)))
      else return (Math.sqrt(Math.pow(arr(0)(0).toDouble, 2) - Math.pow(arr(1)(0).toDouble, 2)))
    } else if (missing == "b"){
      if(arr(0).contains("a")) return (Math.sqrt(Math.pow(arr(1)(0).toDouble, 2) - Math.pow(arr(0)(0).toDouble, 2)))
      else return (Math.sqrt(Math.pow(arr(0)(0).toDouble, 2) - Math.pow(arr(1)(0).toDouble, 2)))
    } else return (Math.sqrt(Math.pow(arr(0)(0).toDouble, 2) + Math.pow(arr(1)(0).toDouble, 2)))
  }
}