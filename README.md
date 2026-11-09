# JavaPilot Demo（Java 代码分析练习仓库）

这是一个专门用于开发 **JavaPilot — AI 研发效能助手** 的测试项目。
它是一个小型 Spring Boot REST API 项目，包含少量有意保留的代码问题，供后续验证：

- 仓库扫描、文件过滤、路径和行号定位
- 关键词 / 类名 / 方法名搜索
- 根据异常堆栈定位代码
- 对 Git Diff 做代码审查
- 将审查结果整理为结构化 JSON

> 注意：本项目中的部分问题是教学用的刻意缺陷，不代表生产代码规范。

## 环境要求

- JDK 17
- Maven 3.9+（也可以使用 IntelliJ IDEA 自带的 Maven）
- IntelliJ IDEA 或 VS Code

## 启动

在项目根目录执行：

```bash
mvn spring-boot:run
```

默认地址：`http://localhost:8080`

如果 Maven Wrapper 尚未生成，可以先使用本机 Maven。也可以在 IntelliJ IDEA 中导入 `pom.xml` 并运行 `JavaPilotDemoApplication`。

## API 示例

### 1. 健康检查

```bash
curl http://localhost:8080/api/health
```

预期返回：

```json
{"status":"UP","service":"javapilot-demo"}
```

### 2. 创建订单

```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d "{\"userId\":\"user-100\",\"amount\":120.00,\"vip\":true}"
```

### 3. 查询订单

```bash
curl http://localhost:8080/api/orders/1001
```

## 目录结构

```text
src/main/java/com/javapilot/demo/
├── JavaPilotDemoApplication.java
├── controller/
│   ├── HealthController.java
│   └── OrderController.java
├── model/
│   ├── CreateOrderRequest.java
│   └── Order.java
├── repository/
│   └── InMemoryOrderRepository.java
└── service/
    ├── DiscountService.java
    └── OrderService.java
src/test/java/com/javapilot/demo/service/
└── DiscountServiceTest.java
fixtures/
├── sample-stacktrace.txt
└── sample-review.diff
docs/
└── engineering-standards.md
```

## 给 JavaPilot 的练习顺序

1. 扫描仓库，过滤 `target/`、`.git/`、IDE 文件和配置密钥。
2. 搜索 `DiscountService`、`createOrder`、`findById`，返回文件路径、行号和代码片段。
3. 输入 `fixtures/sample-stacktrace.txt`，验证能否定位异常位置。
4. 输入 `fixtures/sample-review.diff`，输出包含 `severity`、`file_path`、`line`、`evidence`、`suggestion`、`confidence` 的审查结果。
5. 将结果与 `docs/engineering-standards.md` 对照。

## 教学缺陷提示

代码里故意保留了几个适合代码审查练习的问题，但这里不直接列出答案。后续我们会先让 JavaPilot 找到证据，再讨论哪些是真实缺陷、哪些只是风格建议。
