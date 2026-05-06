# Expo Push Test Harnesses

[![Java CI (Test Harnesses)](https://github.com/expopush/test-harnesses/actions/workflows/build.yml/badge.svg)](https://github.com/expopush/test-harnesses/actions/workflows/build.yml)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java Version](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk)](https://www.oracle.com/java/technologies/downloads/#java17)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot)](https://spring.io/projects/spring-boot)
[![Dependabot](https://img.shields.io/badge/Dependabot-enabled-brightgreen.svg?logo=dependabot)](https://github.com/expopush/test-harnesses/network/updates)

A collection of Spring Boot applications designed to act as "harnesses" for testing the `expo-push` library against various real-world backends.

## Harnesses Included

- **`expo-test-harness-sqs`**: Simulates a production environment using Amazon SQS.
- **`expo-test-harness-h2`**: Uses a local H2 database for persistent message storage without external infrastructure.
- **`expo-test-harness-local`**: Uses an in-memory backend for ultra-fast integration testing.

## Usage

Each harness is a standalone Spring Boot application. To run a specific harness:

```bash
cd expo-test-harness-sqs
mvn spring-boot:run
```

Once running, the harness exposes an HTTP endpoint to accept push requests and forward them to the configured backend.

## Why use this?

These harnesses are used by the [Expo Push Test Target](https://github.com/expopush/test-target) to verify that notifications are correctly queued, processed, and retried across different storage implementations.

## License

Licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE) for details.

---

**Disclaimer**: This project is an independent, open-source work and is not affiliated with, endorsed by, or sponsored by 650 Industries, Inc. or the official Expo project. "Expo" is a trademark of 650 Industries, Inc.
