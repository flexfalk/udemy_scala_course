package exercises

import math.Fractional.Implicits.infixFractionalOps
import math.Integral.Implicits.infixIntegralOps
import math.Numeric.Implicits.infixNumericOps
abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element : B): MyList[B]
  def printElements: String
  //polymorphic call
  override def toString: String = "[" + printElements + "]"
  def ++[B >: A](list: MyList[B]): MyList[B]
  def map[B](myTransformer: MyTransformer[A, B]): MyList[B]

  def filter(predicate : MyPredicate[A]): MyList[A]

  def flatmap[B](transformer : MyTransformer[A, MyList[B]]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""
  def map[B](myTransformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def flatmap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]) : MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else s"$h ${t.printElements}"

  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  def filter(predicate: MyPredicate[A]): MyList[A] =
    if predicate.test(h) then new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[B >: A](list: MyList[B]) : MyList[B] = new Cons(h, t ++ list)

  def flatmap[B](transformer : MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatmap(transformer)

//  def flatmap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = ???

}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}
trait MyTransformer[-A, B] {
  def transform(element: A): B
}
//class EvenPredicate extends MyPredicate[Int]

object ListTest extends App {
  val listOfIntegers: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = Cons(4, Cons(5, Cons(6, Empty)))
  val copyListOfIntegers: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val listOfStrings: MyList[String] = Cons("hello", Cons("scala", Empty))

  println(listOfStrings.toString)
  println(listOfIntegers.toString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int]{
    override def test(elem: Int): Boolean = elem % 2 == 0
  }   ).toString)

  println(listOfIntegers ++ anotherListOfIntegers).toString

  println(listOfIntegers.flatmap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = Cons(element, Cons(element + 1, Empty))

  }
  ).toString)

  println(listOfIntegers == copyListOfIntegers)

}