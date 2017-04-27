<%--
  Created by IntelliJ IDEA.
  User: u3257
  Date: 23.03.2017
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Tas Web File Loader</title></head>
<body>Обновить загрузчик?<br>
<form action="Fldr/run" method="get" onsubmit="clear_pre()">
  <input type="submit" value="Да">
</form>
<script>
    function clear_pre(){
        document.getElementById("some_pre").innerHTML = "loading...";
    }
</script>
<pre id = "some_pre"></pre>
</body>
</html>
