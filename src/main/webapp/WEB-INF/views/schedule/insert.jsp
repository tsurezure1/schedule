<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css" type="text/css">
</head>
<body>
    <h1>新しいスケジュールの追加</h1>
    <div id="scheduleForm">
        <t:messagesPanel />
        <form:form
           action="${pageContext.request.contextPath}/schedule/create"
            method="post" modelAttribute="scheduleForm">
            予定概要：
            <form:input path="scheduleTitle" />
            <form:errors path="scheduleTitle" />
            <br>
            予定開始時刻（YYYYMMDDHHMM）：
            <form:input path="scheduleDateFrom" />
            <form:errors path="scheduleDateFrom" />
            <br>
            予定終了時刻（YYYYMMDDHHMM）：
            <form:input path="scheduleDateTo" />
            <form:errors path="scheduleDateTo" />
            <br>
            予定詳細：
            <br>
            <form:textarea path="scheduleInfo" cols="40" rows="5"/>
            <form:errors path="scheduleInfo" />
            <br>
            <form:button>Create Schedule</form:button>
        </form:form>
    </div>
</body>
</html>