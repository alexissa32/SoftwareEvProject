# Heuristic Build Tool Comparison
## Dylan Bray (DB37299) and Alex Issa (api236)

Build tools are an important aspect of the software development ecosystem. Unfortunately, tools often rebuild code redundantly, wasting time, computational resources, and memory. We propose to evaluate different build tools on representative Java codebases, comparing their performance handling different types of changes in the codebase. This evaluation will consider Maven, Gradle, and Bazel - a new, high-performance tool that claims to handle incremental builds especially well. For expanded scope, Ant and Make may also be considered. We may also expand the scope of the project to consider different languages. The evaluation will compare each build tool’s speed, CPU usage, and memory usage, and may also consider the tools’ ability to scale with parallelization.

Although there are few automated tools available to convert Maven or Gradle to Bazel, there are many guides that take advantage of a nearly one-to-one mapping between the build languages [1, 2]. To start, we will compare the Guava example project [3], since it is a large codebase that is built using Maven, but has officially supported guides to convert the build to Bazel [1]. We will also use the automatic conversion from Maven to Gradle [4] to create build files, so we will have at least one representative codebase, Guava, that we will build with all three tools. To extend this idea, we also propose building Maven using Maven, converting it to Gradle, and finally converting it to Bazel. Finally, we hope to build Tensorflow using at least Maven and Bazel, since both are officially supported [5]. If we are successful with building Tensorflow using Maven and Bazel, we will attempt to build it using Gradle. 

Once we have these representative codebases being built using all possible tools, we will explore making changes to the code and comparing rebuild time, CPU usage, and memory usage. Further, we seek to explore the code through visual representations of dependencies [6]. This will help us choose interesting places in code to make those changes that will showcase differences in the tools.

### 10/13 Update

We downloaded Maven, Guava, Tensorflow, and Apache Commons Math, and built each of these codebases with Maven, then installed Gradle, and performed automatic conversion using the Gradle init tool [4].

### References
1. https://docs.bazel.build/versions/master/migrate-maven.html
2. https://medium.com/wix-engineering/migrating-to-bazel-from-maven-or-gradle-part-1-how-to-choose-the-right-build-unit-granularity-a58a8142c549
3. https://github.com/google/guava
4. https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:automatic_conversion
5. https://github.com/tensorflow/tensorflow/tree/master/tensorflow/java
6. http://maven.apache.org/plugins/maven-dependency-plugin/tree-mojo.html 
