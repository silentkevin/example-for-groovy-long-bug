# A Code Example Showing Long Constants Defined in Groovy 2.5.3 Under OpenJDK 11 Cause an IllegalAccessError

This repository aims to show an example of a issue when using constant longs with groovy 2.5.3 and openjdk 11.

CircleCI build page:  https://circleci.com/gh/silentkevin/example-for-groovy-long-bug

Docker image to run and show the issue:  https://hub.docker.com/r/silentkevin/example-for-groovy-long-bug/

How to run:
- Have docker installed on your system
- run "docker run silentkevin/example-for-groovy-long-bug"

Issue Report Text:

The following groovy code:

```groovy
class SomeBadClass {
    SomeBadClass() {
        Long a = 1_457_366_400_000L
    }
}

new SomeBadClass()
```

causes the following exception to be thrown:

```groovy
java.lang.IllegalAccessError: Update to static final field com.example.SomeBadClass.$const$0 attempted from a different method (__$swapInit) than the initializer method <clinit> 

	at com.example.SomeBadClass.__$swapInit(SomeBadClass.groovy)
	at com.example.SomeBadClass.<clinit>(SomeBadClass.groovy)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
	at org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:83)
	at org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrapNoCoerce.callConstructor(ConstructorSite.java:105)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:237)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:241)
	at com.example.SomeClassFailsTest_3.testSomething(SomeClassFailsTest_3.groovy:37)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runners.Suite.runChild(Suite.java:128)
	at org.junit.runners.Suite.runChild(Suite.java:27)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
```

I created a small sample project to show this happening (using gradle 4.10.2):  https://github.com/silentkevin/example-for-groovy-long-bug

The example project builds a docker image that can be run to easily show the issue:
```bash
docker run silentkevin/example-for-groovy-long-bug
```

Versions:
- Runtime: Oracle OpenJDK 11.0.1 (tried on MacOSX 10.14 and on Debian Linux using official openjdk docker image 11.0.1-jdk)
- Groovy: 2.5.3
- Gradle: 4.10.2
- JUnit: 4.12

Links:
- Sample project:  https://github.com/silentkevin/example-for-groovy-long-bug
- build.gradle:  https://github.com/silentkevin/example-for-groovy-long-bug/blob/master/build.gradle
- Dockerfile:  https://github.com/silentkevin/example-for-groovy-long-bug/blob/master/docker/Dockerfile
- Broken class:  https://github.com/silentkevin/example-for-groovy-long-bug/blob/master/src/main/groovy/com/example/SomeBadClass.groovy
- Broken test 1:  https://github.com/silentkevin/example-for-groovy-long-bug/blob/master/src/test/groovy/com/example/SomeClassFailsTest_1.groovy#L41
- Broken test 2:  https://github.com/silentkevin/example-for-groovy-long-bug/blob/master/src/test/groovy/com/example/SomeClassFailsTest_2.groovy#L42
- Broken test 3:  https://github.com/silentkevin/example-for-groovy-long-bug/blob/master/src/test/groovy/com/example/SomeClassFailsTest_3.groovy#L37
- Test that works fine (just to show the whole project isn't borked):  https://github.com/silentkevin/example-for-groovy-long-bug/blob/master/src/test/groovy/com/example/SomeClassSucceedsTest.groovy#L41

Comments:
- Everything appears to work fine under OpenJDK10 with the exact same code (after changing the source and target compatibility to JDK10 in build.gradle)
- CompileStatic or not doesn't seem to matter
- To compile and run groovy under JDK11 version 2.5.3 of groovy is absolutely required so I can't really test with a different version of groovy

