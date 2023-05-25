<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" description="layout for 1 question" %>

<%@attribute name="question" required="true" type="ru.kpfu.itis.java4.srvergasov.semesterwork.dto.QuestionDto" %>
<%@attribute name="individual" required="true" type="java.lang.Boolean" %>
<%@attribute name="editing" required="true" type="java.lang.Boolean" %>

<c:set var="authUsername" value="${pageContext.request.userPrincipal.name}" />

<div class="p-4 mb-2 text-white rounded-5 bg-dark">
    <c:if test="${!editing}">
        <c:if test="${authUsername eq question.username}">
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/questions/question_delete?questionId=${question.id}">Delete</a>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/questions/question_edit?questionId=${question.id}">Edit</a>
        </c:if>
    </c:if>
    <div>
        <h1 class="display-4 fst-italic"><c:out value="${question.title}" /></h1>
        <p class="lead my-3"><c:out value="${question.description}" /></p>
        <p class="lead my-3">Category: <c:out value="${question.category}"/></p>
        <p>Author: <c:out value="${question.username}"/></p>
        <c:if test="${not individual}">
            <p class="lead mb-0"><a href="${pageContext.request.contextPath}/questions/question?id=${question.id}" class="btn border-1 border-white text-white fw-bold">Open</a></p>
        </c:if>

    </div>
    <jsp:doBody />
</div>