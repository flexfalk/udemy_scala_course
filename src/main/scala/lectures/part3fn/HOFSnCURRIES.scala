package lectures.part3fn

object HOFSnCURRIES extends App{

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  //higher order funktion (HOF) -> When they have funktions as parameters

  //map, flatMap, filter in MyList

  //function that appplies another function n times over a given value x
  // nTimes(f, n, x)
  // ntimes(f, 3, x)= f(f(f(x))) ) = nTimes(f, 2, f(x)) = nTimes(f, 1, f(f(x)))
  //nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n : Int, x: Int): Int =
    if (n<=0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  //ntb(f,n) = x => f(f(f(f(...x)))
  //increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  //val y = increment10(1)
  def nTimesBetter(f: Int=> Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

//  val plus10 = nTimesBetter((plusOne, 10))
//  println(plus10(1))


  //curries

  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // lambda y=> 3 + y

  println(add3(10))
  println(superAdder(10)(3))

  //functions with multiple parameter list
  def curriedFormatter(c: String)(x : Double):String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double=> String)= curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))


  /*
  1. Expand MyList
   - foreach method A=> Unit
    [1, 2, 3].foreach(x => println(x))

    - sort function ((A, A) => Int) => MyList
    [1, 2, 3]. sort((x, y) => y -x) => [3, 2, 1]

   - zipWith (list, (A, A) => MyList[B]
  [1, 2, 3].zipWith[4, 5, 6], x + y) => [4, 10, 30]

    - fold //curied
  fold(start)(function) => a value
  [1, 2, 3].fold(0)(x+y) = 6

  2. toCurry(f: (Int, Int) => Int) => (int => int => int)
      fromCurry(f: int => int => int) => (Int, Int) => Int

  3. Compose(f, g) => x => f(g(x))
    andThen(f, g) => x => g(f(x))

  */
  
  


}
