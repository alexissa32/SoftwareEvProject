# Heuristic Build Tool Comparison
## Dylan Bray (DB37299) and Alex Issa (api236)

Build tools are an important aspect of the software development ecosystem. Unfortunately, tools often rebuild code redundantly, wasting time, computational resources, and memory. We propose to evaluate different build tools on representative Java codebases, comparing their performance handling different types of changes in the codebase. This evaluation will consider Maven, Gradle, and Bazel - a new, high-performance tool that claims to handle incremental builds especially well. For expanded scope, Ant and Make may also be considered. We may also expand the scope of the project to consider different languages. The evaluation will compare each build tool’s speed, CPU usage, and memory usage, and may also consider the tools’ ability to scale with parallelization.

Although there are few automated tools available to convert Maven or Gradle to Bazel, there are many guides that take advantage of a nearly one-to-one mapping between the build languages [1, 2]. To start, we will compare the Guava example project [3], since it is a large codebase that is built using Maven, but has officially supported guides to convert the build to Bazel [1]. We will also use the automatic conversion from Maven to Gradle [4] to create build files, so we will have at least one representative codebase, Guava, that we will build with all three tools. To extend this idea, we also propose building Maven using Maven, converting it to Gradle, and finally converting it to Bazel. Finally, we hope to build Tensorflow using at least Maven and Bazel, since both are officially supported [5]. If we are successful with building Tensorflow using Maven and Bazel, we will attempt to build it using Gradle. 

Once we have these representative codebases being built using all possible tools, we will explore making changes to the code and comparing rebuild time, CPU usage, and memory usage. Further, we seek to explore the code through visual representations of dependencies [6]. This will help us choose interesting places in code to make those changes that will showcase differences in the tools.

### 11/22 Update
In this update, we successfully implemented our own basic math class called Calculator (which adds, subtracts, multiplies, and divides) with Maven as our build management tool. Each of those math functions is its own Maven package, with Multiply and Divide also depending on Add and Subtract. After creating this project, we used the same techniques we previously talked about to convert Calculator to a Gradle and Bazel project. We also generated a dependency graph for Calculator. You can access that repository here: https://github.com/dfbray/swevolutioncalculator

Our main observation regarding Gradle is that it seems to over-promise and under-deliver on converting Maven projects to Gradle projects. Some examples of this are that Gradle does not pick up on our Maven specification of our main class, nor does it pickup on the dependency+jar plugins we use to create the Calculator jar. This means after Gradle generates our build.gradle, we must still manually add the main class specification, as well as equivelent plugins to generate the dependency jars that we need to create the Calculator jar. Now, it is not Gradle's job to manage a mapping of Maven plugins to Gradle plugins, but it is still annoying.

Our main observation regarding Bazel is that it is pretty easy to convert Maven projects to Bazel projects, with one major caveat. Bazel does not have the community support and documentation that Maven or Gradle have. It took us forever to set up the Bazel build because we needed to run a local Maven repository as a server, which is really easy, but the fact that Bazel doesn't support local Maven repositories on its own is frustrating. On top of that, the organization of how our target files are created is confusing (why have a Calculator.jar which doesn't work, AND a Calculator_deploy.jar, which does work...). Combine all of this with how hard it is to find answers, and that sure is frustrating. A good observation is that Bazel builds things REALLY fast, and is very smart about checking for changes before rebuilding.

Our final step is to document how long it takes to build our 3 code bases, as well as track the memory and CPU usage to do so. After that, we will modify different files/parts of the dependency trees for each code base, then see how these changes affect our speed, memory, and CPU usage for each of Bazel, Maven, and Gradle.

### 11/13 Update
In this update, we successfully created visualizations of dependency trees for all of our build tools. Below are instructions on how to accomplish this.

##### Bazel
bazel query 'deps(//:Calculator)' --notool_deps --noimplicit_deps --output graph > graph.in\
open graph.in using Notepad++ and change encoding to ANSI\
save file\
dot "-Tpng" "graph.in" -o "graph.png"

##### Gradle
Add\
plugins {\
  id "com.vanniktech.dependency.graph.generator" version "0.5.0"\
}\
to each root buildfile\
then run gradle generateDependencyGraph

##### Maven
Add
```
<plugin>
  <groupId>com.github.ferstl</groupId>
  <artifactId>depgraph-maven-plugin</artifactId>
  <version>3.3.0</version>
  <configuration>
    <graphFormat>dot</graphFormat>
    <createImage>true</createImage>
    <showDuplicates>true</showDuplicates>
  </configuration>
</plugin>
```
to ```pom.xml```
then run ```mvn depgraph:graph```
then go to ```/target``` to find the generated graph.

We also used source code from https://github.com/astrofrog/psrecord to make a python script that records our CPU and memory usage for PID(s) over time. We do need to refine it some more, then we can move towards actually testing our projects.

### 11/1 Update

After struggling with a few different things, we are slighlty narrowing the focus of our project. We will not be using the Tensorflow repository as a test for Bazel, Gradle, or Maven, as it is such a large repository, we are struggling to build it on our computers and keep having errors [7]. We are unable to build Maven with Gradle or build Gradle with Gradle or Maven (there is no documentation on how to build Gradle from source). As a result, we are pivoting to using Apache Math, Guava, and our own code base to test Maven, Gradle, and Bazel. From there, we will still analyze the tools on build time, CPU usage, and memory usage, and we still intend on visually depicting each repository's dependency tree. A more detailed update on where we are at is in the PowerPoint slides committed in the repository.

The primary changes that were required to be made to the Bazel builds involved dependencies. It appears (although I'm not certain) that maven builds implicitly kept track of dependencies somehow, whereas Bazel builds required dependencies to be explicitly declared so that they would be packaged with the final product jarfile. This resulted in larger and slower builds for the time being. However, we have yet to take advantage of Bazel's strengths by creating BUILD files across the project to take advantage of the large amount of granularity it can achieve.

The gradle init command did not work perfectly with Guava, since the source directory structure did not conform to the default '/src/main/java' which required manually fixing each build.gradle file according to [8]. In addition, there was an issue with Javadoc generation, but since that is not the main focus of our project, I opted to ignore Javadoc creation so as not to waste more time solving that issue. With this update, we successfully build the Commons-Math and core Guava jarfiles with Maven, Gradle, and Bazel.

Other things to note were that we have found different options for Python scripts that should enable us to easily track the CPU/memory usage each time we build something, and our time to completion is provided by all three build tools [9]. Last, we are able to create dependency trees using any of the three tools [10, 11, 12].

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
  gradle/commons-math3-3.6.1-src/build/libs
##### Guava
  gradle init\
  remove line "system 'jdk:srczip:999'" from gradle/guava-30.0/guava/build.gradle\
  follow [8] to account for the source and test locations\
  cd guava\
  gradle build\
  success!\
  gradle/guava-30.0/guava/build/libs
##### TBD
  TODO

#### Bazel Builds:
##### Commons Math
  create BUILD and WORKSPACE files according to [1]\
  bazel build, find errors\
  look up package in maven repo\
  add to BUILD and WORKSPACE\
  solve for dependency issues until done\
  bazel\commons-math3-3.6.1-src\bazel-out\x64_windows-fastbuild\bin
##### Guava
  create BUILD and WORKSPACE files according to [1]\
    bazel build, find errors\
  look up package in maven repo\
  add to BUILD and WORKSPACE\
  solve for dependency issues until done\
  bazel\guava-30.0\bazel-out\x64_windows-fastbuild\bin

### 10/13 Update

We downloaded Maven, Guava, Tensorflow, and Apache Commons Math, and built each of these codebases with Maven, then installed Gradle, and performed automatic conversion using the Gradle init tool [4]. We are using Java 1.8, Maven 3.6, Gradle 6.6.1, and Bazel 3.7.0 for these tasks. We plan next to play around with Bazel and convert the Commons Math library first, since it is the smallest and likely easiest to get started with.

#### Maven Builds (often needed to use this for it work-https://stackoverflow.com/questions/30181154/skipping-some-license-tests-in-maven):
##### Commons Math
  1. Clone the Commons Math repository
  1. Check out the commit corresponding to version 3.6.1 (otherwise your build may fail)
  1. Run ```mvn package``` (add ```-DskipTests``` to skip tests)
  1. Find the built files in ```commons-math3-3.6.1-src/target```
##### Guava
  1. Clone the Guava repository
  1. Check out the commit corresponding to version 30.0 (otherwise your build may fail)
  1. Run ```mvn package``` (add ```-DskipTests``` to skip tests)
  1. Find the built files in ```apache-maven-3.6.3/maven-[component]/target```

#### Gradle Builds (with slight adjustments):
##### Commons Math
  1. Clone the Commons Math repository
  1. Check out the commit corresponding to version 3.6.1 (otherwise your build may fail)
  1. Run ```gradle init```
  1. Run ```gradle build``` (add ```-x tests``` to skip tests)
  1. Success!
  1. Find the built file in ```commons-math3-3.6.1-src/build```
##### Guava
  1. Clone the Guava repository
  1. Check out the commit corresponding to version 30.0 (otherwise your build may fail)
  1. Run ```gradle init```
  1. Remove the lines ```withJavadocJar()``` and ```system 'jdk:srczip:999'``` from ```gradle/guava-30.0/guava/build.gradle```
  1. Run ```gradle build``` (add ```-x tests``` to skip tests)
  1. Success!
  1. Find the built files in ```guava-30.0/[component]/build```

### References
1. https://docs.bazel.build/versions/master/migrate-maven.html
2. https://medium.com/wix-engineering/migrating-to-bazel-from-maven-or-gradle-part-1-how-to-choose-the-right-build-unit-granularity-a58a8142c549
3. https://github.com/google/guava
4. https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:automatic_conversion
5. https://github.com/tensorflow/tensorflow/tree/master/tensorflow/java
6. http://maven.apache.org/plugins/maven-dependency-plugin/tree-mojo.html 
7. https://www.tensorflow.org/install/source_windows
8. https://docs.gradle.org/current/userguide/building_java_projects.html#sec:java_source_sets
9. https://unix.stackexchange.com/questions/554/how-to-monitor-cpu-memory-usage-of-a-single-process
10. https://stackoverflow.com/questions/3342908/how-to-get-a-dependency-tree-for-an-artifact
11. https://stackoverflow.com/questions/21645071/using-gradle-to-find-dependency-tree
12. https://blog.bazel.build/2015/06/17/visualize-your-build.html
