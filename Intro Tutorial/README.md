# Intro to the DOM xml parser for JAVA

The DOM xml parser is one option when it comes to reading xml files in java. It differs from other parsers, because it reads the entire file to memory before accessing it.

Before we start with the main tutorial, we need to go over some fundamentals of getting the xml file into and out of java. After this, we will use some practical examples to show off the power of the DOM parser.

## Building a Document object

In DOM, there are five main interfaces you will interact with

- Node - A basic data type most objects inherit
- Element - A representation of an xml header
- Attribute (Attr) - A subheader or nested subheader
- Text - The content of the Element or Attribute
- Document - The entire xml document represented as a tree

In DOM, building the document is not done by the Document class itself, instead we use DocumentBuilder objects. Instantiating a document builder looks like this:

```java
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
```

You may also point out that DocumentBuilders have to be created by DocumentBuilderFactories. Once you have your builder, it's time to pull your document into java. To do this, you need to pass your xml File object into the DocumentBuilder. It will look something like this:

```java
File xmlFile = new File("link/to/your/file.xml");
Document document = builder.parse(xmlFile);
```

Now that your xml file is inside of java, you can access all the data! You can even alter the document's content and send it back. In the next section, we will use an example to show off each element of a DOM xml tree.
