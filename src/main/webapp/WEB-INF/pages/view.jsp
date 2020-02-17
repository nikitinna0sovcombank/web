<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<div>
    <table>
        <tr><th>Код товара </th><th>Наименование товара</th><th>Цена</th></tr>
        <%
            List<String> list = (List<String>) request.getAttribute("string");
            if (list != null && !list.isEmpty()) {
                for (String s : list) {
                    out.println(s);
                }
            }
        %>
    </table>
</div>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
