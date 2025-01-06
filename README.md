# Creating and Using a Maven Plugin

**Lesson 1: Creating a Simple "Hello-World" Maven Plugin**

### Steps

1. Ensure the `<artifactId>` ends with `-maven-plugin`:
   ```xml
   <artifactId>counter-maven-plugin</artifactId>

2. Include the following dependencies in your pom.xml:

```xml
<dependencies>
  <dependency>
    <groupId>org.apache.maven</groupId>
    <artifactId>maven-plugin-api</artifactId>
    <version>3.6.0</version> <!-- Specify the appropriate version -->
  </dependency>
  <dependency>
    <groupId>org.apache.maven.plugin-tools</groupId>
    <artifactId>maven-plugin-annotations</artifactId>
    <version>3.6.0</version> <!-- Specify the appropriate version -->
  </dependency>
</dependencies>
```
3. Implement the goal:

```java
@Mojo(name = "sayhi")
public class GreetingMojo extends AbstractMojo {
    public void execute() {
        getLog().info("Hello, world.");
    }
}
```

4. Compile, package, and install the plugin into the local .m2 repository:

**Lesson 2: Using the Plugin in a Project**

### Steps

1. Use the plugin anywhere, but your project's basic pom.xml must look like this:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>my-project</artifactId>
  <version>1.0-SNAPSHOT</version>
</project>
```
2. Run the plugin 
directly: mvn com.leonid:hello-maven-plugin:1.0-SNAPSHOT:sayhi


3. To configure the plugin in a Maven project, update the pom.xml as follows:


```xml
<build>
  <plugins>
    <plugin>
      <groupId>com.leonid</groupId>
      <artifactId>hello-maven-plugin</artifactId>
      <version>1.0-SNAPSHOT</version>
      <executions>
        <execution>
          <phase>compile</phase>
          <goals>
            <goal>sayhi</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

3. Invoke the plugin:

#### Directly: ```mvn com.leonid:hello-maven-plugin:1.0-SNAPSHOT:sayhi```
#### Through the compile phase: ```mvn compile```











