package com.snapptrip.crypto

import java.io.File

import com.snapptrip.crypto.conf.ArgParser
import com.snapptrip.crypto.conf.ArgParser.ExcelArgConfig
import scopt.OParser
import com.snapptrip.crypto.dao.ExcelRepo
import com.typesafe.scalalogging.LazyLogging
import com.snapptrip.crypto.util.Utils._
object FileCrypto  extends LazyLogging{
  def main(args: Array[String]): Unit = {
    OParser.parse(ArgParser.excelCryptoArgParser,args,ExcelArgConfig()) match {
      case Some(config)=>
        val inputFilePath=config.inputFilePath
        val outputFilePath=if(config.outputFilePath==".") genOutputPath(inputFilePath) else config.outputFilePath
        val sheetIdx=config.sheetIndex
        val columnIndices=config.columnIndices
        val key=config.key
        val excelRepo=new ExcelRepo(inputFilePath)
        excelRepo.encryptAndExport(sheetIdx,columnIndices,key,outputFilePath)
      case _=>
        logger.error("input arguments' format is not correct! please use the appropriate format of arguments.")
    }

  }
}
