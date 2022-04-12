# java-desktop-technical-service
- We developed a desktop program with Java as the first project with Java in the Java fullstack training of the Istanbul education academy. On the same screen as the technical service program, the user can display customer information, device status information, and ready-to-repair products on the screen.

### Languages, Technologies and Environments Used in this Project

| Java/JFrame  | OOP | SQLite | IntelliJ  |
| :------------: | :------------: | :------------: | :------------: |
|<img src="https://iskulubu.com/wp-content/uploads/2021/06/java.png" width="100">|<img src="https://ccweb.imgix.net/https%3A%2F%2Fd3f1iyfxxz8i1e.cloudfront.net%2Fcourses%2Fcourse_image%2F033d2bd4b880.jpg?ar=16%3A9&auto=format&cs=strip&fit=crop&h=380&ixlib=php-3.3.1&w=535&s=396bdea2da23cd72b8c6adf71525ab23" width="100">|<img src="https://csharpcorner-mindcrackerinc.netdna-ssl.com/UploadFile/55275a/windows-phone-8-1-sqlite-how-to-store-data-in-database/Images/SQLite.jpg" width="100">|<img src="https://www.yazilimevi.com/images/virtuemart/product/JetBrains-IntelliJ-IDEA-Ultimate-2018-indir.png" width="100">|

### Project Overview

| Login |
| ------------ |
|<img src="https://github.com/maruf04/java-desktop-technical-service/blob/main/img/login.gif" >|

- The user can login to the Technical Service Program with the login screen.

| Dashboard |
| ------------ |
|<img src="https://github.com/maruf04/java-desktop-technical-service/blob/main/img/dashboard.gif" >|

- With the Dashboard page, there are two tables that list the products to be repaired, the products that have been repaired and the products to be delivered to the customer. The user can search on them. On the Dashboard screen, the user can navigate to the Customer, Service, and Archive pages.

| CustomerAdd |
| ------------ |
|<img src="https://github.com/maruf04/java-desktop-technical-service/blob/main/img/customer.gif" >|

- With the Customer page, customers can add, delete, update and search the customer table.

| Services |
| ------------ |
|<img src="https://github.com/maruf04/java-desktop-technical-service/blob/main/img/service.gif" >|
- On the Service screen, you can create a record for a new fault product, edit the created record, delete it, and search the records.

| Archive |
| ------------ |
|<img src="https://github.com/maruf04/java-desktop-technical-service/blob/main/img/archive.gif" >|
- On the Archive screen, there is a table containing the previously repaired and delivered products and the information of the owners of these products. The user can search among these products.

| Program |
| ------------ |
|<img src="https://github.com/maruf04/java-desktop-technical-service/blob/main/img/1.gif" >|

#### Database Model
| Database Model |
| ------------ |
|<img src="https://github.com/maruf04/java-desktop-technical-service/blob/main/img/SQLLiteDB.png" width="750">|
                
+ models
    + IUser
    + UserImpl
    + ICustomer
    + CustomerImpl
    + IService
    + ServiceImpl
    + ICustomerService
    + CustomerService
+ props
    + User
    + Customer
    + Service
    + CustomerService
+ utils
    * DB
    * Util
+ views
    * Login
    * Base
    * Dashboard
    * CustomerAdd
    * Services
    * Archive
                    



### Demo Account
                    
 🔐 Email  | 🗝️Password
------------- | -------------
admin@gmail.com  | 1234



#### Maruf Akan
