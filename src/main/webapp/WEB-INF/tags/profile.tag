<%@tag pageEncoding="UTF-8" description="layout for profile page" %>

<%@attribute name="user" required="true" type="ru.kpfu.itis.java4.srvergasov.semesterwork.dto.UserDto" %>

<div class="w-50 mx-auto">
    <div class="card" style="border-radius: 15px;">
        <div class="card-body p-4">
            <div class="d-flex text-black">
                <div class="flex-grow-1 ms-3">
                    <h5 class="mb-1"><c:out value="${user.username}"/></h5>
                    <div class="d-flex justify-content-start rounded-3 p-2 mb-2"
                         style="background-color: #efefef;">
                        <div>
                            <p class="small text-muted mb-1">Rating</p>
                            <p class="mb-0">${user.rating}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:doBody />
    </div>
</div>