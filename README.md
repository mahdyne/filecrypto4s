# filecrypto4s
# What?
Just a Scala library to encrypt/decrypt various files and also fields of structured files.
# How to ...?
val excelRepo=new ExcelRepo(inputFilePath) \
excelRepo.encryptAndExport(sheetIdx,columnIndices,key,outputFilePath) \

### Build
git clone https://github.com/mahdyne/filecrypto4s.git \
*sbt assembly*
### **Required** args
-i, --inputFile \
-o, --outputFile  \
-s, --sheetIdx  \
-c, --columnIndices   
-k, --key <key> \

### Run
*java -jar filecrypto4s-assembly-0.1.jar -i users.xls -o users_encrypted.xls -s 2 -c 8,9 -k a1b2c3*