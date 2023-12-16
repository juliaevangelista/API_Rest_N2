## Banco de Dados
~~~sql
CREATE USER 'devdev'@localhost IDENTIFIED BY 'dev' ;

CREATE DATABASE redesocial ;

GRANT ALL ON redesocial.* TO 'devdev' @localhost

    WITH GRANT OPTION ;
    
FLUSH PRIVILEGES ;

use redesocial ;
CREATE TABLE redesocial (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nomeusuario VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    textopostagem TEXT NOT NULL,
    numerocurtidas INTEGER NOT NULL,
    bio VARCHAR (255) NOT NULL
) ;
~~~

## Endpoints

- Listar todos os eventos: GET http://localhost:8080/api/redesocial

- Obter um evento específico: GET http://localhost:8080/api/redesocial/{id}

- Criar um novo evento: POST http://localhost:8080/api/redesocial

- Atualizar um evento existente: PUT http://localhost:8080/api/redesocial/{id}

- Excluir um evento: DELETE http://localhost:8080/api/redesocial/{id}
