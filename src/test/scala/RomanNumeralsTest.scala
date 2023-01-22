import org.scalatest._
import flatspec._

class ExampleTest extends AnyFlatSpec {

  import MorseDecoder.*


  "The example from the description" should "return \"HEY JUDE\"" in  {
    assertResult("HEY JUDE")(decodeMorse(decodeBits("00000011001100110011000000110000001111110011001111110011111100000000000000110011111100111111001111110000001100110011111100000011111100110011000000110000")))
  }

  "The example from the description2" should "t" in {
    assertResult("-.")(decodeBits("00000000000111111001100000000000000000"))
  }
}
