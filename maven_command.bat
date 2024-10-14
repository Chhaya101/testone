@ECHO OFF

:choice
set /P environment="Do you want to run local (L) or on SauceLabs (S)? [L/S] (default: s)" || SET "environment=s"
set /p tag="Enter tag (default: wip): " || SET "tag=WIP"
set /P nmsc="Enter NMSC (default: en_gb_acc): " || SET "nmsc=en_gb_acc"
set /P name="Enter a name for your test build: "

FOR /F "tokens=1,2 delims==" %%G IN (src\test\resources\credentials.properties) DO (set %%G=%%H)

if /I "%environment%" EQU "L" goto :local
if /I "%environment%" EQU "S" goto :sauce_labs
goto :choice

:local
echo "Start to run local with tag %tag%"
call mvn -DbambooBuildNumber=%name% -DRUNNER=%tag% -DNMSC=%nmsc% -DENVIRONMENT=Local clean compile verify
start "" ".\target\cucumber-report-html\extent-reports\report.html"
pause
exit

:sauce_labs
echo "Start to run on SauceLabs with tag %tag%"
call mvn -DbambooBuildNumber=%name% -DRUNNER=%tag% -DNMSC=%nmsc% -DENVIRONMENT=SauceLabs -DsauceLabsUsername=%sauceLabsUsername% -DsauceLabsAccessKey=%sauceLabsAccessKey% clean compile verify
start "" ".\target\cucumber-report-html\extent-reports\report.html"
pause
exit