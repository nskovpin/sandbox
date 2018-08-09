package com.hbc.parser

import com.hbc.parser.Names._

import scala.util.parsing.combinator.RegexParsers



case class WordFreq(word: String, count: Int) {
  override def toString = "Word <" + word + "> " +
    "occurs with frequency " + count
}

class NameParser extends RegexParsers {

  def nameParser: Parser[Name] = {

    def name: Parser[Name] = {

      def nikolay: Parser[Nikolay.type] = "Nikolay" ^^^ Nikolay

      def taylor: Parser[Taylor.type] = "Taylor" ^^^ Taylor

      def alex: Parser[Alex.type] = "Alex" ^^^ Alex

      def daniel: Parser[Daniel.type] = "Daniel" ^^^ Daniel

      nikolay | taylor | alex | daniel
    }
    name
  }

  def phraseParser: Parser[String] = {
    def phrase: Parser[String] = "[a-z]*".r ^^ {_.toString}
    phrase
  }

  def namePhraseParser:Parser[(Name, Option[String])] = {

    nameParser ~ ":" ~ phraseParser ^^ { case n ~ ":" ~ p => (n, Some(p))} |
      phraseParser ~ ":" ~ nameParser ^^ { case p ~ ":" ~ n => (n, Some(p))} |
    nameParser <~ "-nc".? ^^ (n => (n, None))
  }

}

class SimpleParser extends RegexParsers {
  def word: Parser[String]   = """[a-z]+""".r ^^ { _.toString } ^^^ "This is new result "
  def number: Parser[Int]    = """(0|[1-9]\d*)""".r ^^ {x => x.toInt }
  def simpleWord: Parser[String] = "Nikolay" ^^^ {"asd"}
  def freq: Parser[WordFreq] = phrase(word ~ number)        ^^ { case wd ~ fr => WordFreq(wd,fr) }

}

object TestSimpleParser extends SimpleParser {
  def main(args: Array[String]) = {
    parse(freq, "johnny 121") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }

    parse(word, "thisis 23") match {
      case Success(matched,a) => println(matched + a.toString)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }
  }
}


object TestDifficultParser extends NameParser {
  def main(args: Array[String]) = {
    parse(namePhraseParser, "thisisyourphrase:Nikolay") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }

    parse(namePhraseParser, "phrase:Daniel") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }
    parse(namePhraseParser, "Alex:phrase") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }
    parse(namePhraseParser, "Taylor-3nc") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }

  }
}