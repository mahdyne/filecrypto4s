# filecrypto4s
# What?
Just a Scala library to encrypt/decrypt various files and also fields of structured files.
# How?
val excelRepo=new ExcelRepo(inputFilePath)

excelRepo.encryptAndExport(sheetIdx,columnIndices,key,outputFilePath)
