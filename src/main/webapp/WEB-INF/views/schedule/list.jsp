<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css" type="text/css">
</head>
<body>
    <h1>Schedule List</h1>
    <hr/>
    <div id="scheduleForm">
    <t:messagesPanel />
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
                    <form:form
                        action="${pageContext.request.contextPath}/schedule/delete"
                        method="post" modelAttribute="scheduleForm"
                        cssStyle="display: inline-block;">
                        <form:hidden path="scheduleId"
                            value="${f:h(schedule.scheduleId)}" />
                        <form:button>Delete</form:button>
                    </form:form>
                    <br>
                    予定時間：${f:h(schedule.scheduleDateFrom)} - ${f:h(schedule.scheduleDateTo)}        
                    <br>
                    <form:form
                        action="${pageContext.request.contextPath}/schedule/info"
                        method="post"
                        modelAttribute="scheduleForm"
                        cssStyle="display: inline-block;">
                        <form:hidden path="scheduleId"
                            value="${f:h(schedule.scheduleId)}" />
                        <form:button>Information</form:button>
                    </form:form>
                    </li>
            </c:forEach>
        </ul>
    </div>
    <hr>
    <input type="button" value="Add schedule" onClick="document.location='insert';">
    
 </body>
</html>