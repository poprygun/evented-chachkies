# Learn about Spring Boot Application Events

__And Spring Native, just for fun__

## Build Native image

```bash
mvn spring-boot:build-image
```

This step should create `docker.io/library/evented-chachkies:0.0.1-SNAPSHOT` OCI image.

## Run it and be amazed how fast it is

```bash
docker run -it docker.io/library/evented-chachkies:0.0.1-SNAPSHOT
2021-03-18 19:59:56.834  INFO 1 --- [           main] o.s.nativex.NativeListener               : This application is bootstrapped with code generated with Spring AOT

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.3)

2021-03-18 19:59:56.836  INFO 1 --- [           main] i.m.e.e.EventedChachkiesApplication      : Starting EventedChachkiesApplication using Java 11.0.10 on 9d3e3bf400d5 with PID 1 (/workspace/io.microsamples.events.eventedchachkies.EventedChachkiesApplication started by cnb in /workspace)
2021-03-18 19:59:56.836  INFO 1 --- [           main] i.m.e.e.EventedChachkiesApplication      : No active profile set, falling back to default profiles: default
2021-03-18 19:59:56.870  INFO 1 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2021-03-18 19:59:56.871  INFO 1 --- [           main] i.m.e.e.EventedChachkiesApplication      : Started EventedChachkiesApplication in 0.045 seconds (JVM running for 0.05)

```
