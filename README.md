# Heuristic Build Tool Comparison
## Dylan Bray (DB37299) and Alex Issa (api236)

Build tools are an important aspect of the software development ecosystem. Unfortunately, tools often rebuild code redundantly, wasting time, computational resources, and memory. We propose to evaluate different build tools on representative Java codebases, comparing their performance handling different types of changes in the codebase. This evaluation will consider Maven, Gradle, and Bazel - a new, high-performance tool that claims to handle incremental builds especially well. For expanded scope, Ant and Make may also be considered. We may also expand the scope of the project to consider different languages. The evaluation will compare each build tool’s speed, CPU usage, and memory usage, and may also consider the tools’ ability to scale with parallelization.

Although there are few automated tools available to convert Maven or Gradle to Bazel, there are many guides that take advantage of a nearly one-to-one mapping between the build languages [1, 2]. To start, we will compare the Guava example project [3], since it is a large codebase that is built using Maven, but has officially supported guides to convert the build to Bazel [1]. We will also use the automatic conversion from Maven to Gradle [4] to create build files, so we will have at least one representative codebase, Guava, that we will build with all three tools. To extend this idea, we also propose building Maven using Maven, converting it to Gradle, and finally converting it to Bazel. Finally, we hope to build Tensorflow using at least Maven and Bazel, since both are officially supported [5]. If we are successful with building Tensorflow using Maven and Bazel, we will attempt to build it using Gradle. 

Once we have these representative codebases being built using all possible tools, we will explore making changes to the code and comparing rebuild time, CPU usage, and memory usage. Further, we seek to explore the code through visual representations of dependencies [6]. This will help us choose interesting places in code to make those changes that will showcase differences in the tools.

### 11/1 Update

After struggling with a few different things, we are slighlty narrowing the focus of our project. We will not be using the Tensorflow repository as a test for Bazel, Gradle, or Maven, as it is such a large repository, we are struggling to build it on our computers and keep having errors [7]. We are unable to build Maven with Gradle or build Gradle with Gradle or Maven (there is no documentation on how to build Gradle from source). As a result, we are pivoting to using Apache Math, Guava, and our own code base to test Maven, Gradle, and Bazel. From there, we will still analyze the tools on build time, CPU usage, and memory usage, and we still intend on visually depicting each repository's dependency tree. A more detailed update on where we are at is in the PowerPoint slides committed in the repository.

#### Maven Builds (often needed to use this for it work-https://stackoverflow.com/questions/30181154/skipping-some-license-tests-in-maven):
##### Commons Math (built from scratch using mvn package)
  maven/commons-math3-3.6.1-src/target
##### Guava (built from scratch using mvn install -DskipTests then mvn package -DskipTests)
  maven/guava-30.0/guava/target
##### TBD
  TODO

#### Gradle Builds (with slight adjustments):
##### Commons Math
  gradle init\
  gradle build\
  success!\
  gradle/commons-math3-3.6.1-src/build/lib
##### Guava
  gradle init\
  remove line "system 'jdk:srczip:999'" from gradle/guava-30.0/guava/build.gradle\
  gradle build\
  success!\
  gradle/guava-30.0/guava/build
##### TBD
  TODO

#### Bazel Builds:
##### Commons Math
  TODO
##### Guava
  TODO
##### TBD
  TODO

### 10/13 Update

We downloaded Maven, Guava, Tensorflow, and Apache Commons Math, and built each of these codebases with Maven, then installed Gradle, and performed automatic conversion using the Gradle init tool [4]. We are using Java 1.8, Maven 3.6, and Gradle 6.6.1 for these tasks. We plan next to play around with Bazel and convert the Commons Math library first, since it is the smallest and likely easiest to get started with.

#### Maven Builds (often needed to use this for it work-https://stackoverflow.com/questions/30181154/skipping-some-license-tests-in-maven):
##### Maven (built from scratch using mvn package)
  maven/apache-maven-3.6.3/maven-[component]/target
##### Gradle
  TBD
##### Commons Math (built from scratch using mvn package)
  maven/commons-math3-3.6.1-src/target
##### Guava (built from scratch using mvn install -DskipTests then mvn package -DskipTests)
  maven/guava-30.0/guava/target
##### Tensorflow
  N/A

#### Gradle Builds (with slight adjustments):
##### Maven
  not possible?
##### Gradle
  gradle build\
  needs Java 9-11 (ugh)
##### Commons Math
  gradle init\
  gradle build\
  success!\
  gradle/commons-math3-3.6.1-src/build
##### Guava
  gradle init\
  remove line "system 'jdk:srczip:999'" from gradle/guava-30.0/guava/build.gradle\
  gradle build\
  success!\
  gradle/guava-30.0/guava/build
##### Tensorflow
  N/A

### References
1. https://docs.bazel.build/versions/master/migrate-maven.html
2. https://medium.com/wix-engineering/migrating-to-bazel-from-maven-or-gradle-part-1-how-to-choose-the-right-build-unit-granularity-a58a8142c549
3. https://github.com/google/guava
4. https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:automatic_conversion
5. https://github.com/tensorflow/tensorflow/tree/master/tensorflow/java
6. http://maven.apache.org/plugins/maven-dependency-plugin/tree-mojo.html 
7. https://www.tensorflow.org/install/source_windows
