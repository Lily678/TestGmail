# Test google mail

This test logins in gmail page, counts emails and sends a message to user with Selenium Grid (for Chrome).

## Prerequisites
Windows 10 x64 Professional
Google Chrome version 72.0.3626.109

## Installation

Download files:
1. Selenium Server Standalone [https://docs.seleniumhq.org/download/]
2. Chrome Driver [https://sites.google.com/a/chromium.org/chromedriver/downloads]
3. Allure [https://bintray.com/qameta/generic/allure2]
If it is a zip file, extract it in the using folder
4. Should be set environment variable Password 

## Usage
You need to execute two .bat files (exist in bat directory)
Start hub:

```bash
java -jar selenium-server-standalone-3.141.59.jar -role hub
```
Start node:
```bash
java -Dwebdriver.chrome.driver="C:\UsedFolder\chromedriver_win32\chromedriver.exe" -jar "C:\UsedFolder\selenium-server-standalone-3.141.59.jar" -role node -hub "http://192.168.246.201:4444/grid/register/"
```
For using allure you need to add pass to allure file in Path Windows
C:\UsedFolder\allure-commandline-2.10.0\allure-2.10.0\bin

## Running Test
Start two .bat files (start hub and node)
In console start next command:

`mvn clean test (execute test)`

`mvn allure:serve (create html report)`

`mvn allure:report (create report in default repozitory)`
