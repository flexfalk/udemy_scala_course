package lecture1.part1basics

object ValuesVariablesTypes extends App {

  //values
  val x: Int = 5
  println(x)
  // VALS ARE IMMUTABLE

  //COMPILER can infer types (understand what they are, like python. You dont need to declare the type)

  val aString: String = "hjello world!"

  val aBoolean: Boolean = false

  val aChar: Char = 'a'
  val aInt: Int = 42
  val aShort: Short = 45
  val aLong : Long = 100000L
  val aFloat: Float=2.0f
  val aDouble: Double = 3.14

  // variables. They can be changed
  var aVariable: Int = 4
  aVariable = 5 // side effects


}
