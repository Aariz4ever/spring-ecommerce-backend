# 🛒 E-Commerce Product Management API (Backend)

A Spring Boot application that provides CRUD operations for managing products in an e-commerce system.
Built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**, this backend service enables creation, retrieval, updating, and deletion of products through RESTful APIs.

---

## 📌 Features

* ➕ Add new products
* 📄 Fetch all products / fetch by ID
* ✏️ Update existing product details
* 🗑️ Delete product
* 🗃️ Persist data using JPA + Hibernate
* 🔗 REST endpoints structured using Controller–Service–Repository pattern
* ✔️ Input validation (if included)

---

# 🚀 Tech Stack Used

### **Backend**

* **Java 17+**
* **Spring Boot** (REST APIs, Validation, Dependency Injection)
* **Spring Data JPA** (ORM layer)
* **Hibernate** (JPA provider for entity ➝ table mapping)
* **MySQL** (Database)
* **Maven** (Build tool)

### **Tools**

* **Postman** (API testing)
* **Git & GitHub** (Version control)
* **IntelliJ IDEA / VS Code** (IDE)

---

# ⚙️ Setup Steps

### **1️⃣ Clone the Repository**

```sh
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

---

### **2️⃣ Configure MySQL Database**

Create a database manually:

```sql
CREATE DATABASE productdb;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

### **3️⃣ Build & Run the Project**

If using IDE → Run `ProductApplication.java`
Or using terminal:

```sh
mvn clean install
mvn spring-boot:run
```

Application will run at:

```
http://localhost:8080
```

---

# 🧩 API Endpoints

### **Add Product**

```
POST /api/products
```

### **Get All Products**

```
GET /api/products
```

### **Get Product by ID**

```
GET /api/products/{id}
```

### **Update Product**

```
PUT /api/products/{id}
```

### **Delete Product**

```
DELETE /api/products/{id}
```

---

# 🖼️ Screenshots

### **2. API Testing (Postman)**

### 🔹 Base API Call
![Postman Screenshot](screenshots/1.png)

### 🔹 Get all products (initially)
![Postman Screenshot](screenshots/2.png)

### 🔹 Posting a Product
![Postman Screenshot](screenshots/3.png)

### 🔹 Get Product of ID {1}
![Postman Screenshot](screenshots/4.png)

### 🔹 Shown in Hibernate ORM
![Database Screenshot](screenshots/5.png)

### 🔹 Posting another product (which increments id++) ie: id = 2
![Postman Screenshot](screenshots/6.png)

### 🔹 Displaying all the products added so far
![Postman Screenshot](screenshots/7.png)

### 🔹 Get Product details of ID {2}
![Postman Screenshot](screenshots/8.png)

### 🔹 Shown in Database
![Database Screenshot](screenshots/9.png)

### 🔹 Updating Product ID {1}
![Postman Screenshot](screenshots/10.png)

### 🔹 Reflects update in Database
![Database Screenshot](screenshots/11.png)

### 🔹 Deleting product ID {1}
![Postman Screenshot](screenshots/12.png)

### 🔹 Displaying all the remaining products in the Database
![Postman Screenshot](screenshots/13.png)

### 🔹 Shown in Database
![Database Screenshot](screenshots/14.png)

# 📘 How It Works

### 🔹 **Spring Boot**

* Provides an auto-configured environment
* Eliminates XML configuration
* Creates embedded server (Tomcat) automatically
* Manages dependencies via Spring Boot Starter

### 🔹 **Spring Data JPA**

* Simplifies repository creation
* Provides built-in CRUD methods
* Converts Java objects ↔ SQL records

### 🔹 **Hibernate (JPA Provider)**

* Performs ORM (Object Relational Mapping)
* Converts Entities → SQL queries
* Manages relationships, lazy loading, caching

### 🔹 **REST Architecture**

* Controller classes expose REST endpoints
* Follows separation of concerns
* JSON is used for request/response

---

# 📄 Project Structure (MVC)

```
src/
 └── main/
      ├── java/com/project/product
      │     ├── controller/
      │     ├── service/
      │     ├── repository/
      │     └── entity/
      └── resources/
            ├── application.properties
            └── static/
```

---

# 🏁 Conclusion

This backend provides all the essential APIs required for managing products in an e-commerce system, built using industry-standard Spring Boot and JPA architecture.

---
