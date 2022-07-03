<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2> Employee, you are welcome! </h2>
<br>
<br>

<%--${param.employeeName} is the most adorable girl!!!--%>

Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>
Your future car: ${employee.carBrand}
<br>
Language(s):
<ul>

    <c:forEach var="lang" items="${employee.languages}">

        <li> ${lang} </li>

    </c:forEach>

</ul>
<br>Phone number: ${employee.phoneNumber}
<br>Your Email: ${employee.email}
</body>

</html>