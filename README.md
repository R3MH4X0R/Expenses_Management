# Expenses_Management
This is expenses manager that uses http://fixer.io to get exchange rates based on EUR

## NOTE
This application work only with free api key!

## Install
Clone the project
```
git clone https://github.com/n7-remax/Expenses_Management.git
```
Use maven to build project

```
mvn clean compile assembly:single
```
Launch it
```
java -jar expenses_management-1.0-jar-with-dependencies.jar
```
If you want to insert your own api key change this line of code between "access_key=" and "&symbols" in class "CurrencyConvertor":

private static final String API_PROVIDER = "http://data.fixer.io/api/latest?access_key=&symbols=USD,EUR,PLN";

Commands for app:

● add 2018-06-25 10 USD Nuka-Cola — adds expense entry to the list of user expenses. Expenses for various dates could be added in any order. Command accepts following parameters:

2018-06-25 — is the date when expense occurred

10 — is an amount of money spent

EUR — the currency in which expense occurred

Nuka-Cola — is the name of product purchased

● list — shows the list of all expenses sorted by date

● clear 2018-06-25 — removes all expenses for specified date, where:
2018-06-25 — is the date for which all expenses should be removed

● total EUR — this command should take a list of exchange rates from http://fixer.io , calculate the total amount of money spent and present it to user in specified currency, where:
EUR — is the currency in which total amount of expenses should
be presented

● exit/stop - to stop application

## Built With
* [Maven](https://maven.apache.org/)
* [GSON](https://github.com/google/gson)
## License

This project is licensed under the MIT License - see the LICENSE.md file for details

