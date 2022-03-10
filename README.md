Hejo Chłopaki! :)

Oto co udało mi się stworzyć, mam nadzieję, że tragedii - aż takiej - nie ma.
Chciałam dać tu tylko znać czego nie udało mi się jeszcze zrealizować:
* Nie zastosowałam Koin'a.
* Nie zajełam się w ogóle BASIC authetication.
* Co najważniejsze na ten moment dane z CSV nie wczytują się na starcie aplikacji, patrzyłam jak można to zrobić właśnie przy użyciu Koin i zostawiłam to na moment, w którym do niego usiądę.
* O braku testów wolałabym nie wspominać, ale liczę, że tym razem wybaczycie.

Postaram się te rzeczy ogarnąć w wolnym czasie, a pewnie część z nich jutro wyjdzie na warsztatach.

Jeśli chodzi o lokalną bazą Mongo to postawiłam ją w Dockerowym kontenerze, poleceniem:
`docker run -d -p 27017:27017 mongo`

Example use cases:
* Example 1
  * Request: `<user>:<password>@localhost:8080?customerId=1`
  * Response: JSON array containing data related to customer with ID 1,
* Example 2
  * Request: `<user>:<password>@localhost:8080?customerId=1,2`
  * Response: JSON array containing data related to customers with IDs 1 and 2,
* Example 3
    * Request: `<user>:<password>@localhost:8080?customerId=ALL`
    * Response: JSON array containing data related to each customer,
* Example 4
    * Request: `<user>:<password>@localhost:8080?customerId=1,test,2`
    * Response: JSON array containing data related to customers with IDs 1 and 2,
* Example 5
    * Request: `<user>:<password>@localhost:8080?customerId=1,3,6`
    * Response: JSON array containing data related to customers with IDs 1 and 3 (there is no customer with ID = 6),
* Example 6
    * Request: `<user>:<password>@localhost:8080`
    * Response: JSON array containing data related to each customer,
* Example 7
    * Request: `<user>:<password>@localhost:8080?customerId=test`
    * Response: Empty JSON array.

