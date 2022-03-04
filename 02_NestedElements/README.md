# Parsing Nested Elements

Sometimes xml elements can have a lot of children. 
Sometimes those children even have children of their own. 
How do we go about retrieving these nested elements?

For this example, we will have an image element with nested descriptive elements.

```xml
<?xml version="1.0"?>
<current_observation version="1.0">
    <image>
        <url>https://weather.gov/images/xml_logo.gif</url>
        <title>NOAA's National Weather Service</title>
        <link>https://www.weather.gov</link>
    </image>
</current_observation>
```

Our goal is to extract the title element that is nested in the image element.
We will each method assuming that we already have the root node of the entire document <current_observation>.

##Method 1: Entire document search

The first method is a quick and dirty way of finding the element.
However, this method will not work for complex documents with duplicate tag names!

All we need to do for this method is simply search the entire root node for the nested element.

```java
Element title = (Element) root.getElementsByTagName("title").item(0);
System.out.println(title.getTextContent());
```

While this method is great for quickly finding the element, it will not work if there is another title in the document. For example:

```xml
<?xml version="1.0"?>
<current_observation version="1.0">
    <title>Weather Scan 1</title>
    <image>
        <url>https://weather.gov/images/xml_logo.gif</url>
        <title>NOAA's National Weather Service</title>
        <link>https://www.weather.gov</link>
    </image>
</current_observation>
```

If your document has this problem, method 2 would be a better option.
##Method 2: Parent search

This method takes a little more preparation, but is a lot more accurate.

In order to start searching for the nested element, we must first navigate to the element's parent.
In other words, to grab the title element in the example, we must first grab the parent image element. We can do this by searching for the parent:

```java
Element image = (Element) root.getElementsByTagName("image").item(0);
```

Once we have our parent element, we can do a search directly from the parent. This is identical to method 1, but we are using the parent instead of the root.

```java
Element title = (Element) image.getElementsByTagName("title").item(0);
System.out.println(title.getTextContent());
```

This method is the preferred method for accessing nested elements because it is more accurate and understandable.

Now that you can pull elements that are nested inside others, we will move on to parsing an xml array of data.