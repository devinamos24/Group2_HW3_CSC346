# Interface Basics

## Node Normalization

After the builder has parsed the xml many elements can be interacted with as we have a document node of nodes. Unfortunately inner text is often parsed as multiple nodes under its parent element.

```java
Document document = builder.parse(xmlFile);
```

To fix this the node is normalized.

> The **normalize()** method puts all Text nodes underneath a node (*including attribute nodes*) into a "normal" form where only structure (e.g., elements, comments, processing instructions, CDATA sections, and entity references) separates Text nodes, i.e., there are neither adjacent Text nodes nor empty Text nodes.

> The normal form is useful for operations that require a particular document tree structure and ensures that the XML DOM view of a document is identical when saved and reloaded." - [w3schools Article](https://www.w3schools.com/xml/met_node_normalize.asp)

## Example


To understand the problem with the parsing method and inner text, see how this xml is represented as a node by the parser. 

This is the xml file
```java
<foo>hello 
wor
ld</foo>
```
```java
Document document = builder.parse(xmlFile);
```
The parser may have separated the inner text as multiple child nodes to the foo element giving us an object like this.
```java
Element foo
    Text node: ""
    Text node: "Hello "
    Text node: "wor"
    Text node: "ld"
```
We want the text to be combined as one inner text node. So we normalize the node

```java
document.getDocumentElement().normalize();
```
After being normalized there is correctly only one node in the foo element.

```java
Element foo
    Text node: "Hello world"

```
[JB Nizet](https://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work)




# Getting Nodes From the Document

This common practice stores the root element and allows us to use the node instance methods on the document node without saying document.*getDocumentElement();* every time.

```java
Element root = document.getDocumentElement();
```
This root element contains the entire xml document as sub elements. There are already two methods for searching the tree for a given element/s. Both of these methods return an element list. If we want a particular element use item(int index). Otherwise the GetElementsByID/Tag will return a list. If grabbing a particular element
```java
Element firstChildOfRoot = root.getFirstChild()

NodeList someElements = document.GetElementsByTag("tagname");

Element myElement = document.GetElementsById("elementId").item(0);
```
There are also multiple methods for grabbing child nodes of a node.
[(Method List)](https://www.programcreek.com/java-api-examples/?class=org.w3c.dom.Document&method=getElementsByTagName)
such as these.

It is sometimes necessary to grab the InnerText of an element or attribute of a tag.

To do this we can use these methods
```java
//gets the TextCOntent of the element host. 
String host_content = host.getTextContent();
//get the tag, with another line
```
As for attributes first we take all the attributes and the specify which. Because the method getNamedItem() returns a node object we have to make sure it is cast as an attribute.
```java
Attr password_xhint = (Attr) password.getAttributes().getNamedItem("xhint");
```


mention casting the first time your grab an element.

fix getElement -> getElements

node.getNodeType()



