package lecture1.part1basics

object Expressions extends App{

  val x = 1 + 2 //EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | << >> >>> (rgith shift with zero extension

  // == != >= < <=a
  println(1==x)

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 //also works with -= *= /=

  print(aVariable)

  //Instructions (DO) vs Expressions (HAS A VALUE)

  //IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)
  //is an expression
  println(if (aCondition) 5 else 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  //NEVER WRITE THIS AGAIN.

  //EVERYTHIN in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit ===void

  println(aWeirdValue)

  //side effects: println(), whiles, reassigning of var, all returning unit
  //example. println() is a value if type unit, and has the side effect of printing something to the console

  //Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y +1
    if (z > 2) "hello" else "goodbye"
  }

}
