# Spring Boot Banking Service Application, a complete CRUD + REST API project

## Technology & Tools
- Spring Boot 3.x
- Java 17+
- MySQL
- Postman
- Intellij IDEA

## Dependency Added
- Spring Data Jpa
- Spring Web
- MySQL Driver
- Lombok

### 1. POST api to create a new account
   URI: http://localhost:8080/account/add

CURL: <code>
curl --location 'http://localhost:8080/account/add' \
--header 'Content-Type: application/json' \
--data '{
"accountHolderName": "mondal",
"balance": 5000
}'
</code>
![](.\src\main\resources\static\1.PNG)

### 2. GET api to get the account detail
   URI: http://localhost:8080/account/get/1

CURL: <code>
curl --location 'http://localhost:8080/account/get/1'
</code>
![](.\src\main\resources\static\2.PNG)

### 3. GET api to get all account detail
   URI: http://localhost:8080/account/get/all

CURL: <code>
curl --location 'http://localhost:8080/account/get/all'
</code>
![](.\src\main\resources\static\3.PNG)

### 4. Put Api to withdraw amount
   URI: http://localhost:8080/account/withdraw

CURL: <code>
curl --location --request PUT 'http://localhost:8080/account/withdraw' \
--header 'Content-Type: application/json' \
--data '{
"accountNo": 1,
"amount": 200
}'
</code>
![](.\src\main\resources\static\4.PNG)

### 5. Put Api to deposit amount
   URI: http://localhost:8080/account/deposit

CURL: <code>
curl --location --request PUT 'http://localhost:8080/account/deposit' \
--header 'Content-Type: application/json' \
--data '{
"accountNo": 1,
"amount": 200
}'
</code>
![](.\src\main\resources\static\5.PNG)

### 6. Put Api to transfer amount
   URI: http://localhost:8080/account/transfer

CURL: <code>
curl --location --request PUT 'http://localhost:8080/account/transfer' \
--header 'Content-Type: application/json' \
--data '{
"fromAccountNo": 1,
"toAccountNo": 2,
"amount": 100
}'
</code>
![](.\src\main\resources\static\6.PNG)

### 7. DELETE api to delete the account detail
   URI: http://localhost:8080/account/delete/1

CURL: <code>
curl --location --request DELETE 'http://localhost:8080/account/delete/1'
</code>
![](.\src\main\resources\static\7.PNG)

