set projectLocation=\\wb-stor01.web.local\transfer$\Svenkatesh\Result\BatchExecution
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause