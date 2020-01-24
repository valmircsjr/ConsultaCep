# Consulta Cep

Sistema Web Desenvolvido em Java EE para obter dados de um Cep por meio de um WebService disponibilizado pelo ViaCep (http://viacep.com.br/).

## Indice
1. [Tecnologias utilizadas](#id1)
2. [Sistema](#id2)
3. [Como executar](#id3)
4. [Observações](#id4)


---

### Tecnologias utilizadas <a name="id1"></a>
* Java EE
* Spring Boot
* JUnit
* Thymeleaf
* JavaScript
* Maven
* Visual Code

---

### Sistema <a name="id2"></a>

O Sistema Web consiste em apresentadar dados de um cep por meio de uma consulta em uma API. Um pdf é gerado em **consultacep/docs**. Há um botão de donwload do PDF, porém ainda não esta funcionando.

Pagina inicial, onde é possivel inserir um cep:

![PgInicial](readmeimgs/pginicial.png)

Após digitar um cep válido, é aprensando os dados da consulta:

![consulta](readmeimgs/consulta.png)

Se o valor inserido for um cep invalido, o sistema emite um aviso:

![aviso](readmeimgs/aviso.png)

----

### Como executar <a name="id3"></a>

Será necessário instalar o Jdk, o Maven e configurar as respectivas variaveis de ambiente.


Faça o clone do repositório:
```
git clone https://github.com/valmircsjr/ConsultaCep.git
```



Para executar o programa:

```
java -jar .\consultacep\target\consultacep-0.0.1-SNAPSHOT.jar
```


Abra seu navegador e acesse: http://localhost:8080/

---

### Observações <a name="id4"></a>
O .jar já está feito, ou seja, basta a penas rodar a aplicação. **Caso haja algum problema, refaça o build**:
```
 mvn -f .\consultacep\pom.xml clean install
```







