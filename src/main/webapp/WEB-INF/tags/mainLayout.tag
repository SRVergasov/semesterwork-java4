<%@tag description="main layout for other pages" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<%@attribute name="jsFiles" %>

<c:set value="${sessionScope.get('SPRING_SECURITY_CONTEXT').authentication}" var="auth"/>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>${title}</title>
    <c:forTokens items="${jsFiles}" delims="," var="file">
        <script defer src="<c:url value="/static/js/${file}" />"></script>
    </c:forTokens>
</head>
<body class="text-center">
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 text-white">Home</a></li>
                <c:if test="${not auth.authenticated}">
                    <li><a id="#link_auth" href="${pageContext.request.contextPath}/login"
                           class="nav-link px-2 text-white">Auth</a></li>
                    <li><a href="${pageContext.request.contextPath}/registration" class="nav-link px-2 text-white">Registration</a>
                    </li>
                </c:if>
                <c:if test="${auth.authenticated}">
                    <li><a href="${pageContext.request.contextPath}/profile"
                           class="nav-link px-2 text-white">Profile</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout" class="nav-link px-2 text-white">Logout</a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/questions" class="nav-link px-2 text-white">Questions</a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/users" class="nav-link px-2 text-white">Top users</a>
                </li>
            </ul>
            <c:if test="${not empty auth.principal.username}">
                <div id="username-label" class="text-end px-2"><c:out value="${auth.principal.username}" /></div>
            </c:if>
        </div>
    </div>
</header>
<div class="b-example-divider"></div>
<div id="#auth_form" style="display: none">

</div>
<div id="#main" class="w-75 mx-auto mt-3">
    <jsp:doBody/>
</div>
</body>

</html>