<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div id="wrapper">
        <h1>スケジューラー</h1>
        <p>ただいまの時刻は ${serverTime}です。</p>
        <input type="button" value="スケジュールへ" onClick="document.location='schedule/list';">
    </div>
</body>
</html>
