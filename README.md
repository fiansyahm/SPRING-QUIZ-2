# SPRING-QUIZ-2
## src/main/application.properties
isi dengan
```C
spring.datasource.url=jdbc:mysql://localhost:3306/namaDb
spring.datasource.username=root
spring.datasource.password=
```
Untuk DB nya, ini saya ambil dari tabel di laravel
```C
 Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->string('email')->unique();
            $table->timestamp('email_verified_at')->nullable();
            $table->string('password');
            $table->boolean('isAdmin');
            $table->rememberToken();
            $table->timestamps();
        });
   ```
