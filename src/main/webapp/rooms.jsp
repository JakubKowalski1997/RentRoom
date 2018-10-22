<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Rooms</h2>

<c:if test="${not empty rooms}">
    <ul>
        <c:forEach var="room" items="${rooms}">
            <li>PRICE: ${room.price}, ADDRESS: ${room.address}</li>
        </c:forEach>
    </ul>
    <h4 class="text-center"><a href="${contextPath}/welcome">Go to home page</a></h4>
</c:if>
</body>
</html>