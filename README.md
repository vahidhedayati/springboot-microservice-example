This is a springboot microservice application, I haven't had time to test / fully complete this project. Just something that I got side tracked with in the aim of learning more about springboot microservices.

In the last few years Hysterix has become deprecated and now changed to a few alternatives I used resilience4j in this project, 

It has also been made into a reactive application using springboot-webflux (It calls using `Flux` for an interation rather than `Mono` for a single object, the end calls are returning a calculation comparing diferent maps arrays within `Java` I had intended to implement a CRUD object which I was going to use Flux and mono methods on.

There is a `registry-app` which uses `eureka-server` the `eureka-clients` are both the `gateway` (purely for scalibility - this needs more thought from my end I must admit) as well as `client1`, `gateway` uses eureka bound name of `client1-app` to communicate rather than physical ip/port

The project if I get the time I will add a react front end something like `Vue` or  `react`  to call backend methods.


