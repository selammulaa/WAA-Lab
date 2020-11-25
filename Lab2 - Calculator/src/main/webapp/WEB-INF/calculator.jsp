<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta charset="ISO-8859-1">
    <h4>Calculator</h4>
</head>
<body>
<c:if test="${errors != null}">

    <p id="errors">
        Error(s)!
    <ul>
        <c:forEach var="error" items="${errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>


</c:if>
<form action="calc" method="post">

    <input name="add1" type="text" class="textBox" value="${calc.add1}"/>+
    <input name="add2" type="text" class="textBox" value="${calc.add2}"/>=
    <input name="sum" type="text" class="textBox" readonly/>
    <br>
    <input name="mult1" type="text" class="textBox" value="${calc.mult1}"/>*
    <input name="mult2" type="text" class="textBox" value="${calc.mult2}"/>=
    <input name="product" type="text" class="textBox" readonly/>
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>