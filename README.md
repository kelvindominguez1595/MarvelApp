<p align="center"><a href="https://developer.android.com/jetpack/compose?hl=es-419" target="_blank">
  <img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjC97Z8BResg5dlPqczsRCFhP6zewWX0X0e7fVPG-G7PuUZwwZVsi9OPoqJYkgqT2h0FI95SsmWzVEgpt8b8HAqFiIxZ98TFtY4lE0b8UrtVJ2HrJebRwl6C9DslsQDl9KnBIrdHS6LtkY/s1600/jetpack+compose+icon_RGB.png" width="300" alt="JetPack Compose Logo"></a>
</p>

## Acerca del proyecto

El siguiente proyecto se utilizo Android Kotlin con Jetpack Compose, el cual se integro la api de Marvel y ademas metodos de autentificacion 
con google account y por credenciales como correo y contraseña, haciendo uso de retrofit2 y Dagger Hilt para consumir las APIs Rest.
1. clonar el projecto 
```
git clone https://github.com/kelvindominguez1595/MarvelApp
```
2. Abrir el projecto con android studio o intellJi

## Desarrollo
Se utilizo el patron de arquitectura MVVM para realizar este projecto.

## Librerias utilizadas
```
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-compiler:2.51")
    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation("com.google.accompanist:accompanist-pager:0.34.0")
    implementation("com.airbnb.android:lottie-compose:6.4.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("androidx.paging:paging-runtime:3.2.1")
    implementation("androidx.paging:paging-compose:3.3.0-alpha05")
```
## Logros
Logros completados
- Integracion de autentificacion Firebase Auth
- Integracion de registro de usuario con Firebase Auth
- Integracion de Api Marvel con Retrofit y Dagger Hilt
- Patron de Trabajo MVVM
- Uso de Jetpack Compose y Creacion de componentes reutilizables
- Listar los personajes de marvel
- Integracion paginacion con Paging 3.2.1
- Ver Detalles de personajes especificos
- Buscar por nombres de personajes
  
## No completados
Puntos no completados
- Agregar a favoritos y guardar localmente


## Video de prueba
- <a href="https://drive.google.com/file/d/1Eb7aETeaB8aKO0i7s3QLAMfa6S0IXswD/view?usp=sharing" target="_blank">Ver video click aquí</a>

## Images de comprobaciones
<img src="https://github.com/kelvindominguez1595/MarvelApp/blob/master/app/src/main/res/drawable/1.jpg" width="200" alt="captura_1">
<img src="https://github.com/kelvindominguez1595/MarvelApp/blob/master/app/src/main/res/drawable/2.jpg" width="200" alt="captura_2">
<img src="https://github.com/kelvindominguez1595/MarvelApp/blob/master/app/src/main/res/drawable/3.jpg" width="200" alt="captura_3">
<img src="https://github.com/kelvindominguez1595/MarvelApp/blob/master/app/src/main/res/drawable/4.jpg" width="200" alt="captura_4">
<img src="https://github.com/kelvindominguez1595/MarvelApp/blob/master/app/src/main/res/drawable/5.jpg" width="200" alt="captura_5">
## License

The Laravel framework is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).
