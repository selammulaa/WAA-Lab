<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title><spring:message code="product.title.save"/></title>
    <style type="text/css">@import url(/css/main.css);</style>
</head>
<body>
<div id="global">
    <h4><spring:message code="product.save.success"/></h4>

    <h5><spring:message code="product.details"/></h5>
    <spring:message code="product.productName"/>: ${product.name}<br/>
    <spring:message code="product.category"/>: ${product.category.name}<br/>
    <spring:message code="product.description"/>: ${product.description}<br/>
    <spring:message code="product.price"/>: $${product.price}

    <form action="listproducts" method="get">
        <input id="submit" type="submit"
               value="<spring:message code="product.list.products" />">
    </form>

</div>
</body>
</html>