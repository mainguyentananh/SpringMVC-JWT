# SpringMVC-JWT
## Tóm Tắt
- Xây dựng từ SpringMVC, Spring Security, Hibernate và Mysql.
- Server Apache TomCat 9 và test bằng Postman.
## Cài đặt
- Tạo database với các bảng:
  - Accounts(id_account, username, password).
  - Roles(id_role, rolename).
  - Account_Role(id,id_account,id_role).
  - RefreshToken (id_rt,expirydate,refreshtoken,id_account)
  - `Nếu insert password từ Mysql nhớ lấy password đã được encode insert vào mình có để class test để lấy password encode`.
## Nội dung
- Cấu hình web.xml, spring-servlet, pom.xml.
- Thêm file application.properties chứa thông tin database Hibernate, jwtconfig.properties cấu hình cho JWT và file log4j.properties.  
- Xây dưng Payload
- Xây dựng Model.
- Xây dựng DAO.
- Xây dựng Service.
- Xây dựng Controller
- Xây dựng Config:
  - Security Config cấu hình cho cho Spring Security.
  - JwtAuthenticationEntryPoint xử lý lỗi.
  - JwtTokenProvider cung cấp jwt cho client khi authenticated.
  - JwtAuthenticationFilter kiểm tra jwt của client.
  - UserPrincipal chứa thông tin tài khoản đăng nhập. Phải implement UserDetails lại vì Spring Security quản lý các tài khoản thông qua UserDetailsService nạp từ UserDetails.
## Kết luận
- Mình cũng tự học nên xây dựng cơ bản và còn nhiều sai sót mong mọi người thông cảm.
- Chúc mọi người thành công.
