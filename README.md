# globale-samples	
	version 0.1
1. Create directory c:\grid\lib and create directory c:\selenium	
2. Download selenium-server-standalone-2.53.0.jar and locate in directory c:\grid\lib	
3. Download chromedriver.exe and locate in directory c:\selenium	
4. Open cmd console with admin privileges ("Run as administrator") get to directory c:\grid\lib	
5. Run command c:\grid\lib>java -jar selenium-server-standalone-2.53.0.jar -role hub	
6. Open additional cmd console with admin privileges ("Run as admininstrator") get to directory C:\Grid\lib		
7. Run c:\grid\lib>java -jar selenium-server-standalone-2.53.0.jar -role node -hub http://localhost:4444/grid/register -browser "browserName=chrome,maxinstance=1,platform=WINDOWS" -Dwebdriver.chrome.driver=c:\selenium\chromedriver.exe	
8. Run sample tests	
