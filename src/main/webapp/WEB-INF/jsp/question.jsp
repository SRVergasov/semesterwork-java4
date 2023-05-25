<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout jsFiles="answerAddingViewScript.js,likeScript.js">

    <layout:question question="${question}" individual="${true}" editing="${false}">

    </layout:question>
    <button id="#btn_add_answer" type="button" class="btn btn-dark">Add answer</button>
    <div id="#form_add_answer" class="bg-dark bg-opacity-50 rounded-5 border-3 w-50 mx-auto border-dark p-2" style="display: none">
        <p>Write answer</p>
        <form method="post" class="border-1 border-dark p-2" action="${pageContext.request.contextPath}/questions/answer_add?questionId=${question.id}">
            <input type="text" class="w-25 mx-auto form-control" name="text" required placeholder="Answer text">
            <input title="submit" type="submit" class="btn btn-dark border-1 border-white m-2">
        </form>
    </div>
    <hr>

    <c:forEach items="${answersList}" var="answer" varStatus="loop">
        <layout:answer answer="${answer}" editing="${false}">

        </layout:answer>
    </c:forEach>

    <hr>
    <section class="fdb-block py-0">
        <div class="container py-5 my-5">
            <div class="row justify-content-center py-5">
                <div class="col-12 col-md-10 col-lg-8 text-center">
                    <div class="fdb-box">
                        <h1><c:out value="${advertisement.title}" /></h1>
                        <p class="lead">
                                <c:out value="${advertisement.description}" />
                        </p>
                        <p class="mt-4">
                            <a class="btn btn-primary" href="${advertisement.href}">Go</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>

</layout:mainLayout>