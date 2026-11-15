# BC Java - Assignment 14 - JPA

![Status](https://img.shields.io/badge/status-completed-brightgreen)
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?logo=intellij-idea&logoColor=white)

* [BC Java - Assignment 14 - JPA](#bc-java---assignment-14---jpa)
    * [Prerequisites](#prerequisites)
        * [Getting Start](#getting-start)
        * [Project Structure](#project-structure)
    * [Questions](#questions)
        * [1. Hello Entity](#1-hello-entity)
        * [2. CRUD Product](#2-crud-product)
        * [3. Search & Filter](#3-search--filter)
        * [4. Quan hệ One-to-Many](#4-quan-hệ-one-to-many)
        * [5. Quan hệ Many-to-Many](#5-quan-hệ-many-to-many)
        * [6. Pagination & Sorting](#6-pagination--sorting)
        * [7. Validation](#7-validation)
        * [8. Custom Query](#8-custom-query)
        * [9. DTO & Mapping](#9-dto--mapping)
    * [Author](#author)

## Prerequisites

- IDE: IntelliJ
- Java 21
- Docker
- MySQL

### Getting Start

- Bước 1: Chạy [docker-compose.yaml](docker-compose.yaml) để cài đặt môi trường cho MySQL
- Bước 2: Connect database với DBBearer/DataGrip và chạy [dump-db_assign_14_jpa.sql](dump-db_assign_14_jpa.sql) để tạo
  schema và sample data

    ```text
    port: 3307
    user: root
    password: Root@1234
    ```

- Bước 3: Start project
- Bước 4: Import [Postman Collection](BC%20Java%20-%20Assignment%2014%20-%20JPA.postman_collection.json) vào Postman để
  test APIs.

### Project Structure

```txt
./
│   .gitattributes
│   .gitignore
│   docker-compose.yaml
│   mvnw
│   mvnw.cmd
│   pom.xml
│   README.md
│
├───.mvn
│   └───wrapper
│           maven-wrapper.properties
│
└───src
    └───main
        ├───java
        │   └───com
        │       └───cybersoft
        │           └───assign_14_jpa
        │               │   Assign14JpaApplication.java
        │               │
        │               ├───controller
        │               ├───entity
        │               ├───repository
        │               ├───request
        │               ├───response
        │               └───services
        │                   └───imp
        │
        └───resources
                application.yaml
```

## Questions

### 1. Hello Entity

- Tạo entity `Student` gồm các trường: `id`, `name`, `email`.
- Tạo repository `StudentRepository`.
- Viết API:
    - `POST /students` → thêm sinh viên.
    - `GET /students` → lấy danh sách sinh viên.

### 2. CRUD Product

- Tạo entity `Product(id, name, price, description)`.
- Viết các API CRUD:
    - `POST /products` → thêm sản phẩm.
    - `GET /products` → lấy tất cả sản phẩm.
    - `GET /products/{id}` → lấy chi tiết sản phẩm.
    - `PUT /products/{id}` → cập nhật.
    - `DELETE /products/{id}` → xóa.

### 3. Search & Filter

- Dùng entity `Book(id, title, author, price)`.
- API:
    - `GET /books/search?author=ABC` → tìm sách theo tác giả.
    - `GET /books/search?minPrice=100&maxPrice=300` → lọc theo khoảng giá.

### 4. Quan hệ One-to-Many

- Entity `Category(id, name) và Product(id, name, price, category)`.
- API:
    - `POST /categories` → tạo category.
    - `POST /categories/{id}/products` → thêm product vào category.
    - `GET /categories/{id}/products` → lấy danh sách product theo category.

### 5. Quan hệ Many-to-Many

- Entity `Student(id, name) và Course(id, title)`, quan hệ nhiều-nhiều.
- API:
    - `POST /students` → thêm student.
    - `POST /courses` → thêm course.
    - `POST /students/{id}/courses/{courseId}` → đăng ký khóa học cho student.
    - `GET /students/{id}/courses` → lấy danh sách khóa học của 1 student.

### 6. Pagination & Sorting

- Entity `Employee(id, name, salary, department)`.
- API:
    - `GET /employees?page=0&size=5&sort=salary,desc` → phân trang + sắp xếp.

### 7. Validation

- Entity `User(id, username, email, password)`.
- Áp dụng `@NotBlank, @Email, @Size(min=6)` để validate.
- API `POST /users` → nếu dữ liệu không hợp lệ thì trả lỗi 400.

### 8. Custom Query

- Entity `Order(id, customerName, totalAmount, createdAt)`.
- Repository viết query:
    - Tìm order theo khoảng ngày.
    - Tìm top 5 order có totalAmount lớn nhất.
- API `GET /orders/top` → trả về top 5 order.

### 9. DTO & Mapping

- Entity `Customer(id, name, email, phone)`.
- API trả về `CustomerDTO` (ẩn email).
- `GET /customers` → chỉ trả về `id, name, phone`.

## Author

Khang Nguyen