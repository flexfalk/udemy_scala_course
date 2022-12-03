package lectures.part2oop

object Exceotions extends App{

  val x: String = null

//  println(x.length)
  //this ^^ will crash with a NPE


  //1. throw exceptions
  //throwing and catching exeptions

//  val aWeirdValue: String = throw new NullPointerException()

  //Throwable classes extends the Throwable class.
  //Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new StackOverflowError("No int for you")
    else 42

  val aWeirdValue = try {
    //code that might fail
    getInt(true)
  } catch {
    case e: StackOverflowError => 43
  } finally {
    //code that will get executed NO MATTER WHAT
    //optional
    //does not influence the return of this expression
    //use finally only for side effects e.g. logging
    println("finally")
  }

    //3. how to define your own exceptions
    class MyException extends Exception
    val exception = new MyException

//    throw exception

    println(aWeirdValue)

    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException("Division by 0")

    object PocketCalculator {
      def add(x: Int, y: Int): Int = {
        val result = x + y
        if (x > 0 && y > 0 && result < 0) throw new OverflowException
        else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
        else result
      }

      def subtract(x: Int, y: Int): Int = {
        val result = x + y
        if (x > 0 && y < 0 && result < 0) throw new OverflowException
        else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
        else result
      }

      def multiple(x : Int, y: Int): Int = {
        val result = x*y
        if (x > 0 && y> 0 && result < 0) throw new OverflowException
        else if (x < 0 && y< 0 && result < 0) throw new OverflowException
        else if (x < 0 && y> 0 && result > 0) throw new UnderflowException
        else if (x > 0 && y< 0 && result > 0) throw new UnderflowException
        else result
      }

      def divide(x: Int, y: Int): Int = {
        if (y == 0) throw new MathCalculationException
        else x / y
      }

    }
    println(PocketCalculator.add(Int.MaxValue, 1))
    /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with a SOError
    3. PocketCalculator
    - add(x, y)
    -muliply(x, y)
    -divide(x, y)
    -substract(x, y)

    Throw a customer excpetion if something wrong happen
    -OverflowException if add(, y) exceeds Int.MAX_VALUE
    -UnderflowExcpetion if substract(x, y) exceeds Int.MIN_VALUE
    -MathCalculation exception for divisoin by zero
    */

}
