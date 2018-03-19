Questa applicazione realizzata su base SpringBoot gestisce una CRUD di un contatto su db mysql tramite Api Rest.

Testata in locale con:
- IntelliJ 2017.3
- Java JDK 9.0.4
- Mysql Server 5.7

Per poterla testare bisogna:
- Avere un mysql server, inserire l'host/porta, user e password in resources/application.properties
- Dentro la folder "ddl" trovate l'sql per creare il db e tabella.
- Avviare l'applicazione (Application.main())
- Ho inserito il supporto di Swagger per fare i test, basta andare in http://localhost:8080/swagger-ui.html
- Provare le varie operazioni del contact controller.

In più ho inserito gli unit test (solo per il controller ma andrebbero fatti anche per gli altri oggetti).