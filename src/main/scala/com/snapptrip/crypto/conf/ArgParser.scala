package com.snapptrip.crypto.conf

import scopt.OParser

object ArgParser {
  case class ExcelArgConfig(inputFilePath:String=".",
                            outputFilePath:String=".",
                            sheetIndex:Int=1,
                            columnIndices:Seq[Int]=Seq(1,2),
                            key:String="1qaz2wsx")
  val builder=OParser.builder[ExcelArgConfig]
  val excelCryptoArgParser={
    import builder._
    OParser.sequence(
      programName("FileCrypto"),
      head("FileCrypto","0.1"),
      opt[String]('i',"inputFile")
        .required()
        .valueName("<inputFile>")
        .action((x,c)=>c.copy(inputFilePath = x))
        .text("inputFile is a required property"),
      opt[String]('o',"outputFile")
        .required()
        .valueName("<outputFile>")
        .action((x,c)=>c.copy(outputFilePath = x))
        .text("outputFile is a required property"),
      opt[Int]('s',"sheetIdx")
        .required()
        .valueName("<sheetIndex>")
        .action((x,c)=>c.copy(sheetIndex = x))
        .text("sheetIndex is a required property"),
      opt[Seq[Int]]('c',"columnIndices")
        .required()
        .valueName("<columnIndices>")
        .action((x,c)=>c.copy(columnIndices = x))
        .text("columnIndices is a required property"),
      opt[String]('k',"key")
        .required()
        .valueName("<key>")
        .action((x,c)=>c.copy(key = x))
        .text("key is a required property")
    )
  }
}
