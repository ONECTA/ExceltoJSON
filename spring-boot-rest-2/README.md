To test using 

JavaScript

var data = "SAMLResponse=abcdef";

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function() {
  if(this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("POST", "http://localhost:8080/parseExcel");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

xhr.send(data);

JQuery

var settings = {
  "url": "http://localhost:8080/parseExcel",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "Content-Type": "application/x-www-form-urlencoded"
  },
  "data": {
    "SAMLResponse": "abcdef"
  }
};

$.ajax(settings).done(function (response) {
  console.log(response);
});

NodeJS

var request = require('request');
var options = {
  'method': 'POST',
  'url': 'http://localhost:8080/parseExcel',
  'headers': {
    'Content-Type': 'application/x-www-form-urlencoded'
  },
  form: {
    'SAMLResponse': 'abcdef'
  }
};
request(options, function (error, response) {
  if (error) throw new Error(error);
  console.log(response.body);
});


Prerequisites for this project:

1. If you have Eclipse, download the STS plug-in from here https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite

2. If you don’t have Eclipse, download STS from here https://spring.io/guides/gs/sts/

3. Download the latest JDK from here http://www.oracle.com/technetwork/java/javase/downloads/index.html

4. Also for testing please download and install POSTMAN tool


Before checkout this project create a folder under C drive like C:\Projects
 
Now open command prompt

1. cd c:\Projects
2. check out the main branch
3. cd spring-boot-rest-2
4. Execute - mvnw clean package
5. start the server - java -jar target\excelapi-0.0.1-SNAPSHOT.jar

To read the excel file of your choice create an application.properties file in  cd c:\Projects directory with below content. Please note to mention the path of excel file you wish to parse as json
app.pathtoexcel=C:\\Users\\Ashutosh\\Desktop\\excelread.xlsx

Then execute 
java -jar excelapi-0.0.1-SNAPSHOT.jar --spring.config.location=application.properties

SAMPLE RUN 
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v2.0.5.BUILD-SNAPSHOT)

2022-08-03 02:22:38.149  INFO 5952 --- [           main] c.x.r.s.main.SpringBootRest2Application  : Starting SpringBootRest2Application v0.0.1-SNAPSHOT on LAPTOP-EJVE1JVO with PID 5952 (C:\Users\Ashutosh\git\spring-boot-rest-2\target\excelapi-0.0.1-SNAPSHOT.jar started by Ashutosh in C:\Users\Ashutosh\git\spring-boot-rest-2)
2022-08-03 02:22:38.154  INFO 5952 --- [           main] c.x.r.s.main.SpringBootRest2Application  : No active profile set, falling back to default profiles: default
2022-08-03 02:22:38.219  INFO 5952 --- [           main] ConfigServletWebServerApplicationContext : Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@64b8f8f4: startup date [Wed Aug 03 02:22:38 IST 2022]; root of context hierarchy
2022-08-03 02:22:39.583  INFO 5952 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-08-03 02:22:39.633  INFO 5952 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-08-03 02:22:39.633  INFO 5952 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.34
2022-08-03 02:22:39.657  INFO 5952 --- [ost-startStop-1] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [C:\Program Files\Java\jdk1.8.0_221\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Program Files\nodejs\;C:\Program Files (x86)\Windows Kits\10\Windows Performance Toolkit\;C:\Program Files\Gemalto\Classic Client\BIN;C:\Program Files (x86)\Gemalto\Classic Client\BIN;C:\Users\Ashutosh\AppData\Local\Microsoft\WindowsApps;C:\Users\Ashutosh\AppData\Roaming\npm;C:\Users\Ashutosh\AppData\Local\Programs\Microsoft VS Code\bin;C:\Program Files\Java\jdk1.8.0_221\bin;;.]
2022-08-03 02:22:39.813  INFO 5952 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-08-03 02:22:39.814  INFO 5952 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1597 ms
2022-08-03 02:22:39.937  INFO 5952 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Servlet dispatcherServlet mapped to [/]
2022-08-03 02:22:39.945  INFO 5952 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2022-08-03 02:22:39.946  INFO 5952 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2022-08-03 02:22:39.948  INFO 5952 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2022-08-03 02:22:39.949  INFO 5952 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2022-08-03 02:22:40.159  INFO 5952 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2022-08-03 02:22:40.446  INFO 5952 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@64b8f8f4: startup date [Wed Aug 03 02:22:38 IST 2022]; root of context hierarchy
2022-08-03 02:22:40.566  INFO 5952 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/parseExcel],methods=[POST],consumes=[application/x-www-form-urlencoded],produces=[application/json;charset=UTF-8]}" onto java.lang.String com.xlsx.read.controllers.ConvertAPI.auth(java.util.Map<java.lang.String, java.lang.String>)
2022-08-03 02:22:40.573  INFO 5952 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2022-08-03 02:22:40.574  INFO 5952 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2022-08-03 02:22:40.628  INFO 5952 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2022-08-03 02:22:40.628  INFO 5952 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2022-08-03 02:22:40.967  INFO 5952 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2022-08-03 02:22:41.100  INFO 5952 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-08-03 02:22:41.105  INFO 5952 --- [           main] c.x.r.s.main.SpringBootRest2Application  : Started SpringBootRest2Application in 3.394 seconds (JVM running for 3.806)
2022-08-03 02:22:56.291  INFO 5952 --- [nio-8080-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
2022-08-03 02:22:56.291  INFO 5952 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2022-08-03 02:22:56.319  INFO 5952 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 24 ms
