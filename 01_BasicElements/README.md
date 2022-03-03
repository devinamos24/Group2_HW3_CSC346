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
This root element contains the entire xml document as sub elements. There are already two methods for searching the tree for a given element/s. Both of these methods return an element list. If we want a particular element use item(int index). Otherwise the GetElementsByID/Tag will return a list. In the case of grabbing a particular element using item(int index); it's important to cast the item as an element.
```java
Element firstChildOfRoot = root.getFirstChild()

NodeList someElements = root.GetElementsByTag("tagname");

Element myElement = (Element) root.GetElementsById("elementId").item(0);
```
We can also grab things like InnerText, attributes, and even tag names from elements.

```java
//gets the TextContent of the element host. 
String host_content = host.getTextContent();

//get the tag, with another line
//here getNamedItem could return anything from the password element so we must cast it as an attribute
Attr password_xhint = (Attr) password.getAttributes().getNamedItem("xhint");

//if we just want the elements name we can use this to grab it as a string. In this case root.getTagName() would return "Document"
String root_tagname = root.getTagName();
```
[There are also many other methods for navigating nodes.
](https://www.programcreek.com/java-api-examples/?class=org.w3c.dom.Document&method=getElementsByTagName)



