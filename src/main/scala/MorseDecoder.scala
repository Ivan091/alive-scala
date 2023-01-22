import scala.annotation.tailrec

import java.util.regex.Pattern

object MorseDecoder {

  import MorseCodes.morseCodes

  private val wordPattern = raw"^(\S+)(.*)".r
  private val longSpacePattern = raw"^(\s{3})(.*)".r
  private val singleSpacePattern = raw"^(\s)(.*)".r

  private val trimZerosPattern = raw"^(0+)(.*)".r
  private val repeatedSeq = raw"^(([0-9])\2*)(.*)".r

  // noinspection RegExpUnexpectedAnchor
  def decodeBits(bits: String): String = {
    @tailrec
    def loop(acc: List[String], s: String): List[String] =
      s match {
        case ""                       => acc
        case repeatedSeq(word, _, xs) => loop(word :: acc, xs)
      }

    val trimmed = trim(bits)

    val rate = loop(List.empty, trimmed).minBy(_.length).length

    val rateDotPattern = s"^(1{$rate}(?=0|$$))(.*)".r
    val rateDashPattern = s"^(1{${rate * 3}}(?=0|$$))(.*)".r
    val rateSymbolSpacePattern = s"^(0{$rate}(?=1))(.*)".r
    val rateCharSpacePattern = s"^(0{${rate * 3}}(?=1))(.*)".r
    val rateWordSpacePattern = s"^(0{${rate * 7}}(?=1))(.*)".r

    @tailrec
    def toMorse(acc: List[String], s: String): List[String] = {
      s match {
        case ""                            => acc
        case rateWordSpacePattern(_, xs)   => toMorse("   " :: acc, xs)
        case rateCharSpacePattern(_, xs)   => toMorse(" " :: acc, xs)
        case rateSymbolSpacePattern(_, xs) => toMorse(acc, xs)
        case rateDashPattern(_, xs)        => toMorse("-" :: acc, xs)
        case rateDotPattern(_, xs)         => toMorse("." :: acc, xs)
      }
    }

    toMorse(List.empty, trimmed).reverse.mkString
  }

  def trim(s: String): String = {
    val prefixTrimmed =
      s match {
        case trimZerosPattern(_, xs) => xs
        case s                       => s
      }

    val trimmed =
      prefixTrimmed.reverse match {
        case trimZerosPattern(_, xs) => xs
        case s                       => s
      }
    trimmed.reverse.trim
  }

  def decodeMorse(msg: String): String = {
    @tailrec
    def loop(acc: List[String], s: String): List[String] =
      s match {
        case ""                        => acc
        case wordPattern(word, xs)     => loop(morseCodes(word) :: acc, xs)
        case longSpacePattern(_, xs)   => loop(" " :: acc, xs)
        case singleSpacePattern(_, xs) => loop(acc, xs)
      }

    loop(List.empty, msg.trim).reverse.mkString
  }
}
