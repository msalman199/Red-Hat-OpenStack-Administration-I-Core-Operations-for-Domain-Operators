<div align="center">

# 🔀 Red Hat Fuse: Cloud-Native Integration with Camel, Karaf & ActiveMQ

![Red Hat Fuse](https://img.shields.io/badge/Red%20Hat%20Fuse-EE0000?style=for-the-badge&logo=redhat&logoColor=white)
![Apache Camel](https://img.shields.io/badge/Apache%20Camel-D0393E?style=for-the-badge&logo=apachecamel&logoColor=white)
![OpenShift](https://img.shields.io/badge/OpenShift-EE0000?style=for-the-badge&logo=redhatopenshift&logoColor=white)
![ActiveMQ](https://img.shields.io/badge/ActiveMQ-D82730?style=for-the-badge&logo=apache&logoColor=white)

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

This lab introduced **Red Hat Fuse**, exploring its core components and deploying a Fuse integration into a cloud-native environment.

---

## 🎯 Key Achievements

In this lab, you:

- 🧩 Explored Red Hat Fuse components (Camel, Karaf, ActiveMQ, and Tooling)
- ☁️ Deployed Fuse integration in a cloud-native environment
- 🌍 Reviewed real-world use cases

---

## 📚 Key Concepts

| Concept | Description |
|---|---|
| **Red Hat Fuse** | Red Hat's distribution of Apache Camel for building enterprise integration solutions |
| **Apache Camel** | The integration framework implementing Enterprise Integration Patterns (EIPs) for routing and transforming data |
| **Apache Karaf** | The OSGi-based runtime container that hosts and manages Fuse integrations |
| **ActiveMQ** | The message broker used for asynchronous messaging between integrated systems |
| **Fuse Tooling** | IDE/tooling support for designing, building, and debugging Camel routes |
| **Enterprise Integration Pattern (EIP)** | A reusable pattern (e.g., splitter, aggregator) for solving common message-routing and transformation problems |
| **Fuse on OpenShift** | Running Fuse integrations as containerized, cloud-native workloads on OpenShift |

---

## 🚀 Next Steps

- 🧪 Experiment with advanced Camel EIPs (e.g., splitter, aggregator)
- ⚡ Explore Fuse on OpenShift with Knative for serverless integrations

---

## 🔧 Troubleshooting Tips

<details>
<summary>Click to expand troubleshooting guidance</summary>

- For Karaf issues, check logs in `apache-karaf-4.4.0/data/log/`
- Use `oc logs <pod-name>` for OpenShift debugging

</details>

<div align="center">

**Made with ❤️ for Al Nafi Training Labs**

![Al Nafi](https://img.shields.io/badge/Al%20Nafi-Training%20Labs-blue?style=for-the-badge)

</div>
