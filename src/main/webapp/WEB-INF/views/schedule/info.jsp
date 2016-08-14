<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule Info</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css" type="text/css">
</head>
<body>

<h1>${f:h(schedule.scheduleTitle)}</h1>
予定時間：${f:h(schedule.scheduleDateFrom)} - ${f:h(schedule.scheduleDateTo)}      
<br>  
予定詳細：
<br>
${f:h(schedule.scheduleInfo)}
<br>
<br>
<input type="button" value="スケジュールへ" onClick="document.location='list';">
</body>
</html>