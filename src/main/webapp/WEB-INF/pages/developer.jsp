<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Developer</title>
</head>
<body>

<h2>Enter developer information</h2>
<form:form method="post" action="addDeveloper">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="price">Specialty</form:label></td>
            <td><form:input path="price" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>