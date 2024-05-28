
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
    <h1>Search Results</h1>
    <c:if test="${not empty result}">
        <table border="1">
            <tr>
                <th>Registration Number</th>
                <th>Color</th>
                <th>Model</th>
                <th>Driver Name</th>
                <th>License Number</th>
            </tr>
            <c:forEach var="vehicle" items="${result}">
                <tr>
                    <td>${vehicle.registrationNumber}</td>
                    <td>${vehicle.color}</td>
                    <td>${vehicle.model}</td>
                    <td>${vehicle.driver.name}</td>
                    <td>${vehicle.driver.licenseNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty result}">
        <p>No vehicles found</p>
    </c:if>
    <a href="searchVehicle.jsp">Back to Search</a>
</body>
</html>
