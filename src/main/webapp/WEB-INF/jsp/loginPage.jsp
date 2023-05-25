<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout>

    <c:if test="${not empty errorText}">
        <div class="alert alert-danger" role="alert">
            <c:out value="${errorText}" />
        </div>
    </c:if>
    <div class="w-25 mx-auto">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div>
                <input name="username" required type="text" placeholder="Username" class="form-control"
                       id="floatingInput">
                <div class="form-text">First time here? <a href="${pageContext.request.contextPath}/registration">registration</a>
                </div>
            </div>
            <div>
                <input name="password" required type="password" placeholder="Password" class="form-control"
                       id="floatingPassword">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button class="btn m-1 btn-lg btn-dark" type="submit">Sign in</button>
        </form>
    </div>


</layout:mainLayout>