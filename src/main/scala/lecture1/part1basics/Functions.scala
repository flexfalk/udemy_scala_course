package lecture1.part1basics
import scala.math._

object Functions extends App{
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int) : String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 5))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String) : Unit =
    println(aString)

  def aBigFunction(n: Int) : Int =  {
    def aSmallerFunction(a: Int, b:Int): Int = a+b


    aSmallerFunction(n, n-1)
  }
  
  //Exercise 1.

  def aGreetingFunction(name: String, age: Int) =
    "Hi, my name is " + name + " and I am " + age + " years old."

  def aFactorial(n : Int) : Int = {
    if (n <= 1) 1
    else n * aFactorial(n-1)
  }

  def aFibonacci(n : Int) : Int = {
    if (n<=2) 1
    else aFibonacci(n-1) + aFibonacci(n - 2)
  }
  
  def isPrime(n: Int): Boolean = {
    def isPrimeUntill(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntill(t-1)

    isPrimeUntill(n/2)
  }
  
  




//
//  def aIsPrime(n: Int): Boolean = {
//    def loop(q: Int): Int = {
////      println(q + " " + sqrt(n))
//      if (q >= sqrt(n)) 0
//      if (n % q == 0) 0
//      else loop(q + 1)
//    }
//    if (loop(2) == 1) true
//    else false
//  }
//
//




  println(aGreetingFunction("Sofus", 26))
  println(aFactorial(5))






}
