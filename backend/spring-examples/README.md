# Spring examples
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-2-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->

[![Build Status](https://img.shields.io/badge/java-17-blue)](https://www.python.org/downloads/)
![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)

The repository contains instructions for using a module from the spring framework (core, boot, data, mvc, security, batch).

## Spring modules

### Core
The Spring Core module, which is the core component of the Spring framework, provides the IoC container There are two types of implementations of the Spring container, namely, bean factory and application context. 
Bean factory is defined using the org.springframework.beans.factory.BeanFactory interface and acts as a container for beans. The Bean factory container allows you to decouple the configuration and specification of dependencies from program logic. 

In the Spring framework, the Bean factory acts as a central IoC container that is responsible for instantiating application objects. It also configures and assembles the dependencies between these objects. There are numerous implementations of the BeanFactory interface. The XmlBeanFactory class is the most common implementation of the BeanFactory interface. This allows you to express the object to compose your application and remove interdependencies between application objects.

* [Spring documentation - spring-core](https://docs.spring.io/spring-framework/reference/core.html)
* [Spring core webinar](https://youtu.be/ZwcHeLhvuq4)

### Boot
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need minimal Spring configuration.

* [Spring documentation - spring-boot](https://spring.io/projects/spring-boot)
* [Spring boot webinar](https://youtu.be/vtPkZShrvXQ)

### Data
Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store.

It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an umbrella project which contains many subprojects that are specific to a given database. The projects are developed by working together with many of the companies and developers that are behind these exciting technologies.

* [Spring documentation - spring-data](https://spring.io/projects/spring-data)
  * [jpa-one-to-one - baeldung.com](https://www.baeldung.com/jpa-one-to-one)
  * [hibernate-one-to-many - baeldung.com](https://www.baeldung.com/hibernate-one-to-many)
  * [jpa-many-to-many - baeldung.com](https://www.baeldung.com/jpa-many-to-many)
  * [jpa-entity-lifecycle-events - baeldung.com](https://www.baeldung.com/jpa-entity-lifecycle-events)
  * [jpa-cascade-types- baeldung.com](https://www.baeldung.com/jpa-cascade-types)
* [Spring data webinar](https://youtu.be/8SGI_XS5OPw)

### MVC
The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings, view resolution, locale and theme resolution as well as support for uploading files. The default handler is based on the @Controller and @RequestMapping annotations, offering a wide range of flexible handling methods. With the introduction of Spring 3.0, the @Controller mechanism also allows you to create RESTful Web sites and applications, through the @PathVariable annotation and other features.

* [Spring documentation - spring-webflow](https://spring.io/projects/spring-webflow)
* [Spring MVC webinar](https://youtu.be/VqptK6_icjk?list=PL82C6-O4XrHejlASdecIsroNEbZFYo_X1)

### Security
Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications.

Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements

* [Spring documentation - spring-security](https://spring.io/projects/spring-security)
* [Spring security webinar](https://youtu.be/b9O9NI-RJ3o)

### Batch
A lightweight, comprehensive batch framework designed to enable the development of robust batch applications vital for the daily operations of enterprise systems.

Spring Batch provides reusable functions that are essential in processing large volumes of records, including logging/tracing, transaction management, job processing statistics, job restart, skip, and resource management. It also provides more advanced technical services and features that will enable extremely high-volume and high performance batch jobs through optimization and partitioning techniques. Simple as well as complex, high-volume batch jobs can leverage the framework in a highly scalable manner to process significant volumes of information.

* [Spring documentation - spring-batch](https://spring.io/projects/spring-batch)
* [Spring batch webinar](https://youtu.be/hr2XTbKSdAQ)

## How to run

**Spring-core example**
```bash
mvn -pl spring-core compile exec:java
```

## Useful links
* [planttext uml online editor](https://www.planttext.com/)
* [start.spring.io](https://start.spring.io/)

## Contributors
<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
     <td align="center"><a href="https://github.com/GeorgeQuantAnalyst"><img src="https://avatars.githubusercontent.com/u/112611533?v=4" width="100px;" alt=""/><br /><sub><b>GeorgeQuantAnalyst</b></sub></a><br /><a href="https://github.com/GeorgeQuantAnalyst" title="Ideas">🤔</a></td>
    <td align="center"><a href="https://github.com/LucyQuantAnalyst"><img src="https://avatars.githubusercontent.com/u/115091833?v=4" width="100px;" alt=""/><br /><sub><b>LucyQuantAnalyst</b></sub></a><br /><a href="https://github.com/LucyQuantAnalyst" title="Code">💻</a></td>
  </tr>
</table>
