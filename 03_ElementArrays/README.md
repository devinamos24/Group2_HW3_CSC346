# Navigating Node Elements

Navigating nodes can be done using node relationships.

In the Document Object Model, node relationships are defined as properties to the nodes:

* parentNode
* childNodes
* firstChild
* lastChild
* nextSibling
* previousSibling

## Example Node Tree:

![NodeTree](https://www.w3schools.com/xml/navigate.gif)
> The image represents a part of the node tree and the relationship between nodes in an example xml

When we retrieve nodes in the node tree via the relationship between nodes, it is often referred to as "navigating nodes".

## Parent and Child Nodes

When navigating element arrays we first need to grab the node that holds the array of elements.

This node is referred to as the parent node. A parent node in turn refers to a xml files root element as seen in the figure above. 
It is important to note that ALL nodes have exactly one parent node.

In this example the following code navigates to the parent node or root node of <states> and normalizes it:
```java
Element root = document.getDocumentElement();
root.normalize();
```
> Refer to "ElementArrays.xml" file for parentNode <states> reference

Next, 

After we grab the root element containing the array, we must pull the first child element in the firstChild node of the array.
The first child element is the first element within a parent node/root element as seen in the image above. 

Getting the first child element allows us to parse and navigate each sibling after the first child much similar to a linked list.

The following navigates to the first element node of the first <state>:
```java
Node node = root.getFirstChild();
```
> Refer to "ElementArrays.xml" file for childNode <state> reference

## Get Node Values

In the DOM parser everything is referred to as a node. Element nodes do not have a text value.

As a result of this, the text value of elements are stored in child nodes like previously mentioned. This node is called a text node.
Unfortunately, when navigating these nodes, `forEach()` loops are not available for node nist objects so we must implement a do while loop in order to include 
the first element we specified before.

It is essential that we obtain the name of the node, depending on its type. In this example we have already specified the node type as the child node above.
This leaves the node name. We use `getNodeName()` to check that the node name we are getting matches the name that we indeed want, in our case it is "state".

```java
node.getNodeName().equals("state")
```
In order to return a node list of elements we need to implement the `getElementsbyTagName()` method. This, with the specified tag name returns a
node list of all elements in the same order they are displayed in the source xml file.

Additionally, we add the `getTextContent()` method in order to return the contents of the node and its respective decendants.

The following demostrates a do-while loop that navigates and extracts node elements in the element array:
```java
do {
    if (node.getNodeName().equals("state")) {
      System.out.println(((Element) node).getElementsByTagName("state").item(0).getTextContent());                
      System.out.println(((Element) node).getElementsByTagName("slug").item(0).getTextContent());                
      System.out.println(((Element) node).getElementsByTagName("code").item(0).getTextContent());                
      /. . ./
    }            
} while ((node = node.getNextSibling()) != null); 
```
`Note:` Many browsers will treat empty white-spaces or new lines as text nodes, Internet Explorer will not.
This causes a problem when using the properties: firstChild, lastChild, nextSibling, and previousSibling within your code. 
To avoid navigating to empty text nodes, we use the if statement to check the node type.

`Additional Notes:` It is important to tread carefully with DOM. Nodes don't always have an important meaning!
Like stated above, there are nodes between each element that are there just for the newline character.

## Resources
[Navigating](https://www.w3schools.com/xml/dom_nodes_navigate.asp)
    
[Get Values](https://www.w3schools.com/xml/dom_nodes_get.asp)
