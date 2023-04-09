 Uygulamayı çalıştırmak için:

1.	YOL:
*Docker desktop ı açınız 
*Projeyi gradle.build ettikten sonra docker compose yml daki services ı çalıştırın
 ![image](https://user-images.githubusercontent.com/96740740/230798596-9f19a42c-ce1e-43ed-ad42-8db2384a01dc.png)

*Bu aşamada postgresql database i ve uygulama ayağa kalkacaktır.

Aşağıdaki link ile endpointler çağırabilir.

http://localhost:8080/swagger-ui/index.html#/


2.YOL:
Postgre de enocaDB database ini  oluşturunuz.
      Application.yml dosyasına kendi uygulamanızın username ve password bilgilerinizi giriniz.
                      url: jdbc:postgresql://localhost:5432/enocaDB
                      username: postgres
                      password: 1234
Sonrasında eğer uygulamayı bir ide de açtıysanız backend challenge applicationdaki backend methodunu çalıştırınız yada gradle build ile jar dosyasını oluşturun . İlgili jar dosyası build.libs klasörünün altında oluşmaktadır.

Aşağıdaki komutu terminalde çalıştırarak uygulamayı başlatabilirsiniz.
Java -jar backendchallenge-0.0.1-SNAPSHOT.jar 
Aşağıdaki link ile endpointler çağırabilir.
http://localhost:8080/swagger-ui/index.html#/




Kullanılan Araç Ve Teklonojiler

•	Programlama Dili : Java
•	Web Framework: Spring MVC
•	Bağımlılık Yönetimi: Gradle
•	Veritabanı:PostgreSQL
                     url: jdbc:postgresql://localhost:5432/enocaDB
                     username: postgres
                     password: 1234

                                                Model

 ![image](https://user-images.githubusercontent.com/96740740/230798609-ecb41ee9-f6c7-46ef-8ae0-27cde763fc2c.png)
 
                                             Endpointler
                                  
![image](https://user-images.githubusercontent.com/96740740/230798662-227a81ea-92a5-4d38-b805-3dc270664d08.png)



