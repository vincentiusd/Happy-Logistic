Building web application(REST API) of LOGISTIC Inventory for rent.

Its called Happy Logistic.

Accounts consists of customer and admin.

admin is responsible for CRUD of Inventory.
customer can add product and rent the inventory. Product is accepted as being keep in the chosen inventory, so customer can only add product after renting an Inventory

Database using Microsft SQL Server Management Studio
Database Name is HappyInv
This project only have one admin customer that was inserted into the database directly.
New user can only register new account as customer.

Database consists of table :
-Account -role management into Admin and Customer and saved username and password
-Customer -table for biodata Customer connected with Account by username
-Product -Name and type of product also Inventory id where that product is being kept. 1 inventory can stored up more than 1 product. this table also have customer Id to connect who the owner of the product
-Inventory -type of inventory(size of inventory) and price of monthly rent
-Transaction -saved customer and inventory id also type of payment that customer used for paying rent

