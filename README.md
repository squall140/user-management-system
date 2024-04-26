# User Management System (ums)


### 1.Introduction

   The whole system include back-end and front-end module based on our requirements(PDF file).

### 2.Installation

- Back-end (ums)
  - maven 3.x  
    - based on maven modules building, the main "pom.xml" is located at the root of the project
    - mainly used command: "mvn clean" | "mvn package" | "mvn install" 
- Front-end (ums-ui)
  - based on ruoyi framework(VueJs), refactored some features including UI, router, and etc.
  - mainly use npm command to get started 
  ```
    1. cd ums-ui
    2. npm install or npm install --registry=https://registry.npmmirror.com
    3. npm run dev 
    4. http://localhost:80
  
    user register: http://localhost/register
    user login:    http://localhost/login 
  ``` 
- PostgreSQL:11-alpine
  ```
  docker pull postgres:11-alpine 
  ``` 
- Redis:6.2.6
  ```
  docker pull redis:6.2.6 
  ``` 
- Docker compose (unnecessary)
  - time always is not enough :) so I decided to implement the docker deployment in the next stage.


### 3. Main Feature

- User register
  - the client can register a member by himself on the URL "http://localhost/register"
  - admin users also can add users directly in the dashboard. When a user was added, a verification email would be sent by UMS.
  - The user can find the login link in the email, once a new member logs on to our system, he only can modify his profile at the profile section.
- User login
  - user can log on to our system on the URL "http://localhost/login"
- Role & Authorization
  - The main design follows the RBAC principal, "user -> role -> resources" model.
  - use Spring security to ensure all of our rest controllers can be accessed by authorization
  - currently, we have two roles "admin"  and "user".
- APIs
  - introduced SwaggerUI to help us implement the API documents. you can easily find it on the dashboard.
- JWT
  - use standard JWT filter to ensure all the requests from client side safety.
  - when a user logs on to our system, he will receive a valid token for his browser.
- Liquibase
  - when springboot starts, it will create some tables in the PostgreSQL automatically, which can allow the UMS to load demo data.
## 


### 4. To be continue
  - Docker deployment (on going)
