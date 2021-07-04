<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty latinEntry.word}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty latinEntry.word}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty latinEntry.word}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty latinEntry.word}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty latinEntry.word}">
        <input type="hidden" name="id" value="${latinEntry.id}">
    </c:if>
    <label for="word">Word</label>
    <input type="text" name="word" id="word">
    <label for="translation">Translation</label>
    <input type="text" name="translation" id="translation">
    <c:if test="${empty latinEntry.word}">
        <input type="submit" value="Add new entry">
    </c:if>
    <c:if test="${!empty latinEntry.word}">
        <input type="submit" value="Edit entry">
    </c:if>
</form>
</body>
</html>
