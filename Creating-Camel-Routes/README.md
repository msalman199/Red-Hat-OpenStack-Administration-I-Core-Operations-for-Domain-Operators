<div align="center">

# 🔌 Camel Routes with File, HTTP, and JMS Components

![Apache Camel](https://img.shields.io/badge/Apache%20Camel-D0393E?style=for-the-badge&logo=apachecamel&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![ActiveMQ](https://img.shields.io/badge/ActiveMQ-D82730?style=for-the-badge&logo=apache&logoColor=white)
![Red Hat Fuse](https://img.shields.io/badge/Red%20Hat%20Fuse-EE0000?style=for-the-badge&logo=redhat&logoColor=white)

</div>

---

## 📖 Table of Contents

- [📋 Overview](#-overview)
- [🎯 Key Achievements](#-key-achievements)
- [📚 Key Concepts](#-key-concepts)
- [🚀 Next Steps](#-next-steps)
- [🔧 Troubleshooting Tips](#-troubleshooting-tips)

---

## 📋 Overview

This lab built on Camel fundamentals by defining routes across **File**, **HTTP**, and **JMS** components, using both Java DSL and XML DSL.

---

## 🎯 Key Achievements

In this lab, you learned how to:

- ✔️ Define Camel routes using Java DSL and XML DSL
- ✔️ Use File, HTTP, and JMS components
- ✔️ Test routes with different data sources

---

## 📚 Key Concepts

| Concept | Description |
|---|---|
| **Java DSL** | Camel's Java-based syntax for defining integration routes in code |
| **XML DSL** | Camel's XML-based syntax for defining integration routes declaratively |
| **File Component** | A Camel component for reading from and writing to the filesystem as a route endpoint |
| **HTTP Component (Camel Jetty)** | A Camel component that exposes or consumes HTTP endpoints via an embedded Jetty server |
| **JMS Component** | A Camel component for sending/receiving messages through a JMS broker such as ActiveMQ |
| **ActiveMQ** | The message broker used as the JMS provider for message-based routes |

---

## 🚀 Next Steps

- 🧩 Explore more Camel components (FTP, Kafka, etc.)
- 🛡️ Implement error handling in routes
- ☁️ Deploy routes on Red Hat OpenShift

---

## 🔧 Troubleshooting Tips

<details>
<summary>Click to expand troubleshooting guidance</summary>

- **File Not Moving?** Check directory permissions
- **HTTP Not Working?** Ensure the Camel Jetty component is running
- **JMS Issues?** Verify ActiveMQ is running (`activemq start`)

</details>

<div align="center">

**Made with ❤️ for Al Nafi Training Labs**

![Al Nafi](https://img.shields.io/badge/Al%20Nafi-Training%20Labs-blue?style=for-the-badge)

</div>
