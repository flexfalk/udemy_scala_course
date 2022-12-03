package lectures.part2oop
import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App{
  //package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  //import the package
//  val princess = new Cinderella does not work for me

//  val princesas = new playground.Cinderella // fullly qualified class name stil now work for me

  //package object

  sayHello
  println(SPEED_OF_LIGHT)

  //imports
//  val prince = new PrinceCharming


  val date = new Date
  val sqlDate = new sqlDate(2018, 4, 5)

  //default imports
  // java.lang = String, Object, Exception etc
  // scala = Int, Nothing, Functiot etc
  // scala.Preddef = println, ???




}
