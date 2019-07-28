package com.snapptrip.crypto.util

import java.io.File

object Utils {
  def genOutputPath(inputFilePath:String):String={
    inputFilePath.split("\\.")(0)+"_encrypted."+inputFilePath.split("\\.")(1)
  }
}
