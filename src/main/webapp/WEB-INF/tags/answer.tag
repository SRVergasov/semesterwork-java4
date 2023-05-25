<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" description="answer layout" %>

<%@attribute name="answer" required="true" type="ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AnswerDto" %>
<%@attribute name="editing" required="true" type="java.lang.Boolean" %>

<c:set var="authUsername" value="${pageContext.request.userPrincipal.name}" />

<div class="container bg-light p-3 text-black rounded-5 border-5">

    <c:if test="${not empty editing}">
        <c:if test="${!editing}">
            <c:if test="${authUsername eq answer.username}">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/questions/answer_delete?answerId=${answer.id}">Delete</a>
            </c:if>
        </c:if>
    </c:if>
    <h2><c:out value="${answer.text}" /></h2>
    <p>Author: <c:out value="${answer.username}" /></p>
    <small id="like_count_answer_${answer.id}" class="opacity-50">Likes: ${answer.likes}</small>
    <c:if test="${!editing}">
        <a id="like_${answer.id}" class="btn btn-outline-danger">Like</a>
    </c:if>
    <jsp:doBody />

</div>
<hr>