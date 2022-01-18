# demo-web
Java 11.0.2

# How to run

**Use next command to run:**
```gradle clean test -DthreadCount=5 -DtestArea=smoke```,\
**where:**\
```threadCount``` - how many threads\
```testArea``` - which test area should run (possible values: ```smoke``` or ```auth```)

**Test report will be in ```build/allure-results``` directory**,\
**use ```allure serve build/allure-results``` command to generate and run allure report**
