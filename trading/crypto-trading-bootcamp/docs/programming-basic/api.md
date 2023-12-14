---
layout: default
title: Api
parent: Programming basic
nav_order: 5
---

# Api
Updated: 4.3.2023 by George
{: .label .label-purple }

An API (Application Programming Interface) is a set of protocols, routines, and tools for building software applications. It specifies how software components should interact and enables communication between different software systems. Essentially, an API provides a way for one software application to interact with another.

APIs can be used to provide access to data, functionality, or services from one application to another. For example, a social media platform might provide an API that allows developers to access and display public user data, such as usernames, profile pictures, and posts, on their own websites or applications. Similarly, an e-commerce platform might provide an API that enables developers to retrieve product information, add items to a shopping cart, and process payments.

APIs can take different forms, but two common types are REST and SOAP. REST (Representational State Transfer) is a web-based architectural style for building APIs that uses HTTP requests to access and manipulate data. SOAP (Simple Object Access Protocol) is a messaging protocol for exchanging structured information between applications. While REST is more lightweight and flexible, SOAP is more rigid and structured.

<center>
<iframe width="720" height="480" src="https://www.youtube.com/embed/GZvSYJDk-us" title="APIs for Beginners - How to use an API (Full Course / Tutorial)" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</center>

## REST
REST stands for Representational State Transfer. It is an architectural style that uses HTTP for communication between client and server. RESTful APIs follow a set of constraints that make them highly scalable and easily maintainable. In a RESTful API, each resource is identified by a unique URL, and the server can perform operations on the resource based on the HTTP request method (e.g. GET, POST, PUT, DELETE). The data is usually transmitted in the form of JSON or XML.

## SOAP
SOAP stands for Simple Object Access Protocol. It is a protocol for exchanging structured data over the web. Unlike REST, which uses HTTP, SOAP can use any transport protocol, such as HTTP, SMTP, or TCP. SOAP messages are typically encoded in XML and are usually transmitted using HTTP. A SOAP message consists of a header, which provides information about the message, and a body, which contains the data being transmitted.