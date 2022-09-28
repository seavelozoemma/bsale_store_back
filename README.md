# API BSALE STORE - JAVA + JPA

API encargada de entregar información de productos y categorias existentes

## Construcción

Para la construcción de está API se utilizo Spring Boot 2 (Java 8) junto con JPA. 
Haciendo uso del API Criteria que se encuentra en el core de JPA.

La conexión esta informada en el archivo .properties de la aplicación

## Servicios

Cuenta con 2 servicios (ambos son solo metodos de lectura (GET)):

/category
Este servicio nos permitira consultar las categorias disponibles

/product?name=${String}&category=${Long}&order=${Long} Este servicio 
nos permitira consultar los productos mediante un filtro en la cual:
#####name: 
Nos permitira filtrar por los nombres de producto
#####category:
Nos permitira filtrar por ID de categoria de producto
#####order:
Nos permitira de manera internar obedecer según lógica de frontend a un ordenamiento:

Orden | Descripción                                         
--- |-----------------------------------------------------
1 | Nos permite filtrar de manera ascendente por nombre 
2 | Nos permite filtrar de manera descendente por nombre
3 | Nos permite filtrar de manera ascendente por precio
4 | Nos permite filtrar de manera descendente por nombre


