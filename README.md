Steps to reproduce:

```
mira@mauna:~/git/carml-xml-issue-1$ java --version
openjdk 11.0.15 2022-04-19
OpenJDK Runtime Environment (build 11.0.15+10-Ubuntu-0ubuntu0.20.04.1)
OpenJDK 64-Bit Server VM (build 11.0.15+10-Ubuntu-0ubuntu0.20.04.1, mixed mode, sharing)

mira@mauna:~/git/carml-xml-issue-1$ mvn exec:java -Dexec.mainClass="XmlTestSuccess"
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< com.zazuko:carml-xml-issue-1 >--------------------
[INFO] Building carml-xml-issue-1 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec-maven-plugin:3.1.0:java (default-cli) @ carml-xml-issue-1 ---
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.408 s
[INFO] Finished at: 2023-09-06T14:26:33+02:00
[INFO] ------------------------------------------------------------------------

mira@mauna:~/git/carml-xml-issue-1$ mvn exec:java -Dexec.mainClass="XmlTestFail"
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< com.zazuko:carml-xml-issue-1 >--------------------
[INFO] Building carml-xml-issue-1 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec-maven-plugin:3.1.0:java (default-cli) @ carml-xml-issue-1 ---
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
[WARNING]
io.carml.logicalsourceresolver.LogicalSourceResolverException: Error executing XPath expression.
    at io.carml.logicalsourceresolver.XPathResolver.xpathPathFlux (XPathResolver.java:154)
    at io.carml.logicalsourceresolver.XPathResolver.lambda$getXpathResultFlux$2 (XPathResolver.java:120)
    at reactor.core.publisher.FluxCreate.subscribe (FluxCreate.java:95)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxFlatMap.trySubscribeScalarMap (FluxFlatMap.java:200)
    at reactor.core.publisher.FluxFlatMap.subscribeOrReturn (FluxFlatMap.java:93)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8657)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onNext (FluxFlatMap.java:427)
    at reactor.core.publisher.FluxIterable$IterableSubscription.slowPath (FluxIterable.java:335)
    at reactor.core.publisher.FluxIterable$IterableSubscription.request (FluxIterable.java:294)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onSubscribe (FluxFlatMap.java:371)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:201)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:83)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxConcatArray$ConcatArraySubscriber.onComplete (FluxConcatArray.java:258)
    at reactor.core.publisher.FluxConcatArray.subscribe (FluxConcatArray.java:78)
    at reactor.core.publisher.Mono.subscribe (Mono.java:4485)
    at reactor.core.publisher.Mono.block (Mono.java:1733)
    at io.carml.engine.rdf.RdfRmlMapper.toModel (RdfRmlMapper.java:368)
    at io.carml.engine.rdf.RdfRmlMapper.mapToModel (RdfRmlMapper.java:351)
    at XmlTestCommon.doConversion_0 (XmlTestCommon.java:57)
    at XmlTestFail.main (XmlTestFail.java:6)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:279)
    at java.lang.Thread.run (Thread.java:829)
Caused by: javax.xml.xpath.XPathException: org.xml.sax.SAXException: javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,1]
Message: Premature end of file.
javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,1]
Message: Premature end of file.
    at jlibs.xml.sax.dog.XMLDog.sniff (XMLDog.java:192)
    at io.carml.logicalsourceresolver.XPathResolver.xpathPathFlux (XPathResolver.java:152)
    at io.carml.logicalsourceresolver.XPathResolver.lambda$getXpathResultFlux$2 (XPathResolver.java:120)
    at reactor.core.publisher.FluxCreate.subscribe (FluxCreate.java:95)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxFlatMap.trySubscribeScalarMap (FluxFlatMap.java:200)
    at reactor.core.publisher.FluxFlatMap.subscribeOrReturn (FluxFlatMap.java:93)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8657)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onNext (FluxFlatMap.java:427)
    at reactor.core.publisher.FluxIterable$IterableSubscription.slowPath (FluxIterable.java:335)
    at reactor.core.publisher.FluxIterable$IterableSubscription.request (FluxIterable.java:294)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onSubscribe (FluxFlatMap.java:371)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:201)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:83)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxConcatArray$ConcatArraySubscriber.onComplete (FluxConcatArray.java:258)
    at reactor.core.publisher.FluxConcatArray.subscribe (FluxConcatArray.java:78)
    at reactor.core.publisher.Mono.subscribe (Mono.java:4485)
    at reactor.core.publisher.Mono.block (Mono.java:1733)
    at io.carml.engine.rdf.RdfRmlMapper.toModel (RdfRmlMapper.java:368)
    at io.carml.engine.rdf.RdfRmlMapper.mapToModel (RdfRmlMapper.java:351)
    at XmlTestCommon.doConversion_0 (XmlTestCommon.java:57)
    at XmlTestFail.main (XmlTestFail.java:6)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:279)
    at java.lang.Thread.run (Thread.java:829)
Caused by: org.xml.sax.SAXException: javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,1]
Message: Premature end of file.
    at io.carml.logicalsourceresolver.PausableStaxXmlReader.run (PausableStaxXmlReader.java:152)
    at io.carml.logicalsourceresolver.PausableStaxXmlReader.start (PausableStaxXmlReader.java:103)
    at io.carml.logicalsourceresolver.PausableStaxXmlReader.parse (PausableStaxXmlReader.java:75)
    at jlibs.xml.sax.dog.XMLDog.sniff (XMLDog.java:189)
    at io.carml.logicalsourceresolver.XPathResolver.xpathPathFlux (XPathResolver.java:152)
    at io.carml.logicalsourceresolver.XPathResolver.lambda$getXpathResultFlux$2 (XPathResolver.java:120)
    at reactor.core.publisher.FluxCreate.subscribe (FluxCreate.java:95)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxFlatMap.trySubscribeScalarMap (FluxFlatMap.java:200)
    at reactor.core.publisher.FluxFlatMap.subscribeOrReturn (FluxFlatMap.java:93)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8657)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onNext (FluxFlatMap.java:427)
    at reactor.core.publisher.FluxIterable$IterableSubscription.slowPath (FluxIterable.java:335)
    at reactor.core.publisher.FluxIterable$IterableSubscription.request (FluxIterable.java:294)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onSubscribe (FluxFlatMap.java:371)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:201)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:83)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxConcatArray$ConcatArraySubscriber.onComplete (FluxConcatArray.java:258)
    at reactor.core.publisher.FluxConcatArray.subscribe (FluxConcatArray.java:78)
    at reactor.core.publisher.Mono.subscribe (Mono.java:4485)
    at reactor.core.publisher.Mono.block (Mono.java:1733)
    at io.carml.engine.rdf.RdfRmlMapper.toModel (RdfRmlMapper.java:368)
    at io.carml.engine.rdf.RdfRmlMapper.mapToModel (RdfRmlMapper.java:351)
    at XmlTestCommon.doConversion_0 (XmlTestCommon.java:57)
    at XmlTestFail.main (XmlTestFail.java:6)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:279)
    at java.lang.Thread.run (Thread.java:829)
Caused by: javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,1]
Message: Premature end of file.
    at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.next (XMLStreamReaderImpl.java:652)
    at io.carml.logicalsourceresolver.PausableStaxXmlReader.run (PausableStaxXmlReader.java:150)
    at io.carml.logicalsourceresolver.PausableStaxXmlReader.start (PausableStaxXmlReader.java:103)
    at io.carml.logicalsourceresolver.PausableStaxXmlReader.parse (PausableStaxXmlReader.java:75)
    at jlibs.xml.sax.dog.XMLDog.sniff (XMLDog.java:189)
    at io.carml.logicalsourceresolver.XPathResolver.xpathPathFlux (XPathResolver.java:152)
    at io.carml.logicalsourceresolver.XPathResolver.lambda$getXpathResultFlux$2 (XPathResolver.java:120)
    at reactor.core.publisher.FluxCreate.subscribe (FluxCreate.java:95)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxFlatMap.trySubscribeScalarMap (FluxFlatMap.java:200)
    at reactor.core.publisher.FluxFlatMap.subscribeOrReturn (FluxFlatMap.java:93)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8657)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onNext (FluxFlatMap.java:427)
    at reactor.core.publisher.FluxIterable$IterableSubscription.slowPath (FluxIterable.java:335)
    at reactor.core.publisher.FluxIterable$IterableSubscription.request (FluxIterable.java:294)
    at reactor.core.publisher.FluxFlatMap$FlatMapMain.onSubscribe (FluxFlatMap.java:371)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:201)
    at reactor.core.publisher.FluxIterable.subscribe (FluxIterable.java:83)
    at reactor.core.publisher.Flux.subscribe (Flux.java:8671)
    at reactor.core.publisher.FluxConcatArray$ConcatArraySubscriber.onComplete (FluxConcatArray.java:258)
    at reactor.core.publisher.FluxConcatArray.subscribe (FluxConcatArray.java:78)
    at reactor.core.publisher.Mono.subscribe (Mono.java:4485)
    at reactor.core.publisher.Mono.block (Mono.java:1733)
    at io.carml.engine.rdf.RdfRmlMapper.toModel (RdfRmlMapper.java:368)
    at io.carml.engine.rdf.RdfRmlMapper.mapToModel (RdfRmlMapper.java:351)
    at XmlTestCommon.doConversion_0 (XmlTestCommon.java:57)
    at XmlTestFail.main (XmlTestFail.java:6)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:279)
    at java.lang.Thread.run (Thread.java:829)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.544 s
[INFO] Finished at: 2023-09-06T14:26:39+02:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.codehaus.mojo:exec-maven-plugin:3.1.0:java (default-cli) on project carml-xml-issue-1: An exception occurred while executing the Java class. Error executing XPath expression.: org.xml.sax.SAXException: javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,1]
[ERROR] Message: Premature end of file.
[ERROR] javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,1]
[ERROR] Message: Premature end of file.
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```