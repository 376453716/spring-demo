<%@ page import="org.apache.log4j.Logger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Logger log = Logger.getLogger("index");
    log.info("test info log....");
    log.debug("test debug log....");
%>
test.
</body>
</html>
