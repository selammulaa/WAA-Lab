<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title><spring:message code="product.add.title" /></title>
<style type="text/css">@import url(/css/main.css);</style>
</head>
<body>

<div id="global">
<form:form modelAttribute="product" action="product" method="post">
    <fieldset>
        <legend><spring:message code="product.add" /></legend>
        <p>
            <label for="category"><spring:message code="product.category" />: </label>
            <form:select id="category" path="category" items="${categories}"
                         itemLabel="name" itemValue="id" />
        </p>
         
        <p>
            <label for="name"><spring:message code="product.productName" />: </label>
            <form:input id="name" path="name" tabindex="1"/>
        </p>
        <p>
            <label for="description"><spring:message code="product.description" />: </label>
            <form:input id="description" path="description"  tabindex="2"/>
        </p>
        <p>
            <label for="price"><spring:message code="product.price" />: </label>
            <form:input id ="price" path="price" tabindex="3" />
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4" value="<spring:message code="product.button.reset" />">
            <input id="submit" type="submit" tabindex="5" 
                value="<spring:message code="product.button.add" />">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
