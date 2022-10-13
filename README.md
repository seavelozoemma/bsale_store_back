# API BSALE STORE - JAVA + JPA

API encargada de entregar información de productos y categorias existentes

## Construcción

Para la construcción de está API se utilizo Spring Boot 2 (Java 8) junto con JPA. 
Haciendo uso del API Criteria que se encuentra en el core de JPA.

La conexión esta informada en el archivo .properties de la aplicación

# Rest API

Cuenta con 2 servicios (ambos son solo metodos de lectura (GET)):

## Obtener listado de categorias

### Request
`GET /category/`
        
    curl --location --request GET 'const API_URL = 'https://bsale-store-back.herokuapp.com/category/'


### Response 
    HTTP/1.1 200 Ok
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 Pl
    Connection: close
    Content-Type: application/json
    Location: /category/
    Content-Length: 36

    [{
        "id": 1,
        "name": "bebida energetica"
    }]


Este servicio nos permitira obtener un listado de categorias.

###Request
`GET /product/`

    curl --location --request GET 'https://bsale-store-back.herokuapp.com/product/?name=&category=0&order=0'

###Response
    HTTP/1.1 200 Ok
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 Ok
    Connection: close
    Content-Type: application/json
    Location: /product/?name=&category=0&order=0
    Content-Length: 36

    [{
        "id": 5,
        "name": "ENERGETICA MR BIG",
        "urlImage": "https://dojiw2m9tvv09.cloudfront.net/11132/product/misterbig3308256.jpg",
        "price": 1490.0,
        "discount": 20.0,
        "category": {
            "id": 1,
            "name": "bebida energetica"
        }
    }]
Este servicio nos permitira consultar los productos mediante un filtro en la cual:

__name__: Nos permitira filtrar por los nombres de producto 

__category__:Nos permitira filtrar por ID de categoria de producto

__order__: Nos permitira de manera internar obedecer según lógica de frontend a un ordenamiento:

Orden | Descripción                                         
--- |-----------------------------------------------------
1 | Nos permite filtrar de manera ascendente por nombre 
2 | Nos permite filtrar de manera descendente por nombre
3 | Nos permite filtrar de manera ascendente por precio
4 | Nos permite filtrar de manera descendente por nombre


