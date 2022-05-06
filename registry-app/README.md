### Creation of registry app

```bash
spring init --name=registry-app --packageName=com.vh.test.mircoservice --dependencies=cloud-eureka-server registry-app.zip
mkdir registry-app
cd registry-app
unzip ../registry-app.zip
```
### Enable Eurka Server `src/main/java/com/vh/test/microservice/RegistryAppApplication.java`

```
package com.vh.test.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryAppApplication.class, args);
	}

}

```


### Update configuration  `src/main/resources/application.properties`

```
server.port=9001
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.service-url.defaultZone=http://localhost:9001/eureka/
```
