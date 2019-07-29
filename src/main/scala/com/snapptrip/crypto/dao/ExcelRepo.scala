package com.snapptrip.crypto.dao

import java.io.File
import java.io.{File, FileOutputStream}

import com.snapptrip.crypto.crypto.Crypto
import com.typesafe.scalalogging.LazyLogging
import org.apache.poi.ss.usermodel._
class ExcelRepo(inputFilePath:String) extends LazyLogging{
  import collection.JavaConverters._
  def getWorkbook: Workbook ={
    val inputFile=new File(inputFilePath)
    val workbook = WorkbookFactory.create(inputFile)
    workbook
  }
  def getSheet(sheetIdx:Int): Sheet ={
    val sheet=this.getWorkbook.getSheetAt(sheetIdx)
    sheet
  }
  def encryptFields(sheet:Sheet,fieldIdxs:Seq[Int],key:String)={
    for (row<-sheet.asScala.drop(1)){
      fieldIdxs.foreach { fieldIdx =>
        row.getCell(fieldIdx) match {
          case null => None
          case sensitiveCell =>
            val encryptedValue=sensitiveCell.getCellType match{
              case CellType.NUMERIC=>
                val intValue = sensitiveCell.getNumericCellValue
                val encryptedValue = Crypto.encrypt(key, intValue.toString)
                Some(encryptedValue)
              case CellType.STRING=>
                val strValue=sensitiveCell.getStringCellValue
                val encryptedValue = Crypto.encrypt(key, strValue)
                Some(encryptedValue)
              case CellType.BOOLEAN=>
                val booleanValue=sensitiveCell.getBooleanCellValue
                val encryptedValue = Crypto.encrypt(key, booleanValue.toString)
                Some(encryptedValue)
              case CellType.BLANK=>
                None
              case _ =>
                val strValue=sensitiveCell.getStringCellValue
                val encryptedValue = Crypto.encrypt(key, strValue)
                Some(encryptedValue)
            }
            sensitiveCell.setCellValue(encryptedValue.getOrElse(""))
        }
      }
    }
  }
  def overwrite(filePath:String,workbook:Workbook)={
    val out=new FileOutputStream(filePath)
    workbook.write(out)
    out.close()
  }
  def encryptAndExport(sheetIdx:Int,fieldIdxs:Seq[Int],key:String,outputFile:String)={
    val workbook=getWorkbook
    encryptFields(workbook.getSheetAt(sheetIdx),fieldIdxs,key)
    val out=new FileOutputStream(outputFile)
    workbook.write(out)
    println("Encrypted and exported successfully")
  }

}