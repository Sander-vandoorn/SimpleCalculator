# Starten van de backend
```
mvn clean install | mvn spring-boot:run -f ./simple-calculator-rest/pom.xml
```

# Starten van de frontend
```
cd simple-calculator-frontend | ng serve -o
```

## Aantal verbeterpunten
1. In het geval van Java 17 zou ik de enumeratie van de operandes vervangen voor de nieuwe manier van implicit casting middels switch/case.
2. Ik zou het contract tussen front en backend middels OpenAPI laten opzetten, automatisch genereren van endpoints in de backend + httpclients in de frontend
3. De styling van de website is nu volledig leeg. Dit kan uiteraard mooier gemaakt worden.
4. ErrorHandling toevoegen, eg. divide by zero, geen backend beschikbaar
