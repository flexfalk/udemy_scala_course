package lectures.part2oop

object Enums{
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    //add fields/methods
    def openDocument(): Unit =
      if (this==READ) println("opening document...")
      else println("reading not allowed")

  }

  val somePermissions: Permissions = Permissions.READ

  //constructor arguments
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits =
      PermissionsWithBits.NONE
  }

  // standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values // array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") // Permissions.READ

  def main(args : Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)
  }


}
