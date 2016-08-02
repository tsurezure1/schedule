<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css" type="text/css">
</head>
<body>
    <h1>Schedule List</h1>
    <div id="scheduleForm">
        <t:messagesPanel />
        <form:form
           action="${pageContext.request.contextPath}/schedule/create"
            method="post" modelAttribute="scheduleForm">
            <form:input path="scheduleTitle" />
            <form:errors path="scheduleTitle" />
            <form:input path="scheduleDateFrom" />
            <form:errors path="scheduleDateFrom" />
            <form:input path="scheduleDateTo" />
            <form:errors path="scheduleDateTo" />
            <form:button>Create Schedule</form:button>
        </form:form>
    </div>
    <hr />
    <div id="scheduleList">
        <ul>

            <c:forEach items="${schedules}" var="schedule">
                <li><c:choose>
                        <c:when test="${schedule.finished}">
                            <span class="strike">
                            ${f:h(schedule.scheduleTitle)}
                            </span>
                        </c:when>
                        <c:otherwise>
                            ${f:h(schedule.scheduleTitle)}
                            <form:form
                                action="${pageContext.request.contextPath}/schedule/finish"
                                method="post"
                                modelAttribute="scheduleForm"
                                cssStyle="display: inline-block;">
                                <form:hidden path="scheduleId"
                                    value="${f:h(schedule.scheduleId)}" />
                                <form:button>Finish</form:button>
                            </form:form>
                         </c:otherwise>
                    </c:choose>
                    ${f:h(schedule.scheduleDateFrom)}
                    <p>
                     - 
                    </p>
                    ${f:h(schedule.scheduleDateTo)}                    
                    <form:form
                        action="${pageContext.request.contextPath}/schedule/delete"
                        method="post" modelAttribute="scheduleForm"
                        cssStyle="display: inline-block;">
                        <form:hidden path="scheduleId"
                            value="${f:h(schedule.scheduleId)}" />
                        <form:button>Delete</form:button>
                    </form:form>
                    </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>