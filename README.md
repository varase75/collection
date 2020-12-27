My filter
=============

Microservicio que filtra la colección de datos de la API externa (unsplash.com) se ha realizado sobre springboot 2 y JAVA 8 con una arquitectura en tres capas:
* Controlador
* Servicio
* Modelo (capa de acceso al API externo).

La API externa tiene una seguridad Oauth2, para conseguir el token es necesario mandar un 'code' de un sólo uso que se obtiene de la página unsplash.com al estar logado como usario registrado (he creado un usuario con un correo personal). Se ha incluido directamente un token (no caduca) obtenido con el endpoint proporcionado (https://unsplash.com/oauth/token).
Se ha incluido swagger para poder probar el API desde el directorio raiz.

### Endpoint de filtrado
```
curl -X GET 'http://localhost:8443/collection/all?filter={filter}
```
El parámetro filter es opcinal y case sensitive.
