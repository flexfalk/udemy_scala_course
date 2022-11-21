package lecture1.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App{

  def factorial(n : Int) : Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n +  " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computing factorial of " + n)
      result
    }
  println("hello")

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) //TAIL RECURSION = use recursive call as the LAST expression
    factHelper(n, 1)
  }
//  println(anotherFactorial(500))
  //WHEN YOU NEED LOOPS, USE _TAIL_RECURSION


  //EXERCISES

  //Exercise 1:
  def repeatString(aString : String, aInt: Int): String = {
    @tailrec
    def loop(aString : String, aInt : Int, accumulator : String): String =
      if (aInt<1) accumulator
      else loop(aString, aInt-1, accumulator + aString)

    loop(aString, aInt, "")
    }
  println(repeatString("sofus", 5))

  //Exercise 2:
  def isPrime(n : Int): Boolean = {
    @tailrec
    def loop(t : Int, n : Int, accumulator: Boolean): Boolean =
      if (t <=1) accumulator
      else loop(t-1, n , accumulator && n % t !=0 )

    loop(n/2, n, true)

  }

  println(isPrime(629))
  //Exercise 3:
  def fibonacci(n : Int): Int = {
    @tailrec
    def loop(i: Int, Last: Int, NextToLast: Int): Int =
      if (i>=n) Last
      else loop(i+1, Last + NextToLast, Last)

    if (n<=2) 1
    else loop(2, 1, 1)
  }

  println(fibonacci(5))


//  def aFibonacci(n: Int): Int = {
//    if (n <= 2) 1
//    else aFibonacci(n - 1) + aFibonacci(n - 2)
//  }


}
