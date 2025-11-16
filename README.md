# Api con graphql

### Api de consultas

```shell
curl --location 'http://localhost:8080/api-policies/get' \
--header 'Content-Type: application/json' \
--data '{"query":"query {\n  policies {\n    policyId, \n    name, \n    coverages{\n      coverageId,\n      name,\n      description\n    }\n  }\n}","variables":{}}'
```
### consola de graphql
En el archivo resources/static/graphiql.html configurar el endpoint para consultas definida en el application.properties
```javascript
const fetcher = GraphiQL.createFetcher({
    url: '/api-policies/get',
});
```

### Consola de base datos h2 para pruebas
http://localhost:8080/h2-console