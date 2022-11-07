

## Tracing Concept

https://ryanharrison.co.uk/2021/08/06/distributed-tracing-spring-boot-jaeger.html

## Testing

Simply try to call a Book API and it inturn calls to read Author data. As a result we get this in tracing. 

> http://localhost:8082/book/1

![alt](./jaeger-ui.png)

> http://localhost:8081/library/1

![alt](./jaeger-ui-library.png)

## Pending Works

OpenTelemetry Project
Custom Tracing Params - Context