package lecture1.part1basics

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  //acces to normal java string operations
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  //special Scala string operations
  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  //preprending and appending to string
  println('a' +: aNumberString :+ 'z')

  println(str.reverse)
  println(str.take(2))


  // S-interpolators

  val name = "David"
  val age = 12
  val greeting = s"Hello, my names is $name and i am $age years old"
  val anotherGreeting = s"Hello, my names is $name and I will be turning ${age + 1 } years old"
  println(greeting)
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minutre"

  print(myth)
}
