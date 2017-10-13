-- To skip run junit during maven clean install -Dmaven.test.skip=true
 
http://localhost:8080/swagger-ui.html#!/booking-controller
http://localhost:8080/v2/api-docs

POST --> http://localhost:8080/booking/create    
GET --> http://localhost:8080/booking/read?bookingId=7     
GET --> http://localhost:8080/booking/getSpecificBooking/9
GET --> http://localhost:8080/booking/readall
PUT --> http://localhost:8080/booking/update/7?psngrName=Jyoti
DELETE --> http://localhost:8080/booking/delete/7
 
====================================== DONE =========================================================== 
- Spring Boot Hot swapping - done
- Exclude Junit test case during Maven Build - done
- Use Spring4 annotation- done @RestController , @GetMapping,  @PostMapping, @PutMapping, @DeleteMapping
- Exception Handling - done
- Form validation - done
- Security - done
- API documentation- done  Swagger: https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/
- Actuator done   - http://localhost:8080/health   , https://www.javatpoint.com/spring-boot-actuator , https://aboullaite.me/an-introduction-to-spring-boot-actuator/
- Caching - done - @Cacheable , @CachePut, @CacheEvict, @EnableCaching
- EHCaching - done - ehcache.xml 
- Logging - done
- Javamelody : done - causing issue with swagger      http://localhost:8080/monitoring
- Mockito Junit : done
- Code Coverage Report - EclEmma : Help -http://www.eclemma.org/installation.html , https://medium.com/@gustavo.ponce.ch/spring-boot-restful-junit-mockito-hamcrest-eclemma-5add7f725d4e
- RestClient - done

====================================== PENDING ===========================================================

- EHCaching - Refresh timer
- Spring Boot Hazelcast Caching
- Pagination
- Filter 
- Sorting
- Report
- Batch
- Searching (using ElasticSearch or another Lucene based search technology) 
- Micro Services ( Netflix)
- Spring Clouds
- Code Review Coverage - Sonar Qube, Cobertura
- Spring AOP
- Spring Boot Admin  - https://dzone.com/articles/a-look-at-spring-boot-admin, http://codecentric.github.io/spring-boot-admin/1.5.1/#_ui_modules
- Spring LDAP
- Spring Rest Upload/Download



