<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout>

    <h1>Here all users sorted by rating</h1>

    <ul class="list-group">
        <c:forEach items="${usersList}" var="user">


            <li class="list-group-item">
                <p class="position-absolute top-50 start-0 ms-3"></p>
                <p>
                    Username: <c:out value="${user.username}" /><br>
                    Rating: <c:out value="${user.rating}" />
                </p>
            </li>

        </c:forEach>
    </ul>

</layout:mainLayout>