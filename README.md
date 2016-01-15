My Homepage Application
============================================

A starter web application project combining Scala, Spring, Spring MVC, Thymeleaf 2.0, Spring Security and twitter bootstrap.

What does it use?
=============

Scala with Spring MVC instead of Java. Thymleaf for templating. 

Stack
=====
* Scala 2.9.2
* Spring 3.2.0 RELEASE
* Spring MVC 3.2.0
* Spring Security 3.2.0 M1
* [Spring Security Scala Extensions](http://blog.springsource.org/2012/12/10/introducing-spring-scala/) - Scala extensions for spring
* [Jacks Jackson module](https://github.com/wg/jacks) - Handle's serialization of objects to JSON. The default Jackson based mapper does not handle scala case classes.
* [Thymeleaf 2.0](http://www.thymeleaf.org) + [Layout Plugin](https://github.com/ultraq/thymeleaf-layout-dialect) - Excellent templating engine. I use 
the layout dialect  to use it for decorating as well.
* Bootstrap - Twitter's Bootstrap CSS
* Logback - for logging. Example showcases how to get Spring to use logback instead of Apache commons logging.
* Maven - For build and jetty integration


How to run
==========
Checkout project, and simply do a  mvn jetty:run and point your browser to http://localhost:8080/

Credits
=======
Based on [thymeleaf-spring-maven-archetype](https://github.com/maggandalf/thymeleaf-spring-maven-archetype)

Zoheb for the starter project:
https://github.com/zoheb/scala-springmvc-thymeleaf-bootstrap-template

Aslan Varoqua


