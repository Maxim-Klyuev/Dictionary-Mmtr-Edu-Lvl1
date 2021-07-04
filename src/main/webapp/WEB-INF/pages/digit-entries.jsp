<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Digit Dictionary</title>
</head>
<body>

<h2>Digit Entries</h2>
<table>
    <tr>
        <th>id</th>
        <th>word</th>
        <th>translation</th>
        <th>action</th>
    </tr>
    <c:forEach var="entry" items="${digitEntries}">
        <tr>
            <td>${entry.id}</td>
            <td>${entry.word}</td>
            <td>${entry.translation}</td>
            <td>
                <a href="/edit/${entry.id}">edit</a>
                <a href="/delete/${entry.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--<h2>Add entry</h2>--%>
<c:url value="/add" var="add"/>
<a href="${add}">Add new entry</a>
</body>
</html>
