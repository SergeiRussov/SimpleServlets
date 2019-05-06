<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculations</title>
</head>
<body>
    <h1>Calculations</h1>

    <form action="${pageContext.request.contextPath}/Calculations" method="post">
        <label for="x">X: </label>
        <input type="text" name="x" id="x" value="${x}">
        <label for="y">Y: </label>
        <input type="text" name="y" id="y" value="${y}">

        <input type="submit" name="operation" value="To add">
        <input type="submit" name="operation" value="To substract">
        <input type="submit" name="operation" value="To multiply">
        <input type="submit" name="operation" value="To split">
        <input type="submit" name="operation" value="Calculate percentage">
    </form>
</body>
</html>