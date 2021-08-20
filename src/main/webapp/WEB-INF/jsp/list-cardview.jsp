<%-- 
    Document   : cc-list
    Created on : Jun 23, 2021, 10:03:50 AM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="editUrlImg" value="/resources/img/edit.png" />
        <c:url var="deleteUrlImg" value="/resources/img/delete.png" />
        <c:url var="viewUrlImg" value="/resources/img/eye.png" />
        <table>
            <tr>
                <th>Id</th>
                <th>Type</th>
                <th>Number</th>
                <th colspan="2"></th>
            </tr>
            <c:forEach items="${person.creditCards}" var="cc">
                <tr>
                    <td><c:out value="${cc.id}"/></td>
                    <td><c:out value="${cc.type}"/></td>
                    <td><c:out value="${cc.number}"/></td>
                    <c:url var="deleteUrl" value="/creditcard/delete">
                        <c:param name="ccId" value="${cc.id}" />
                        <c:param name="personId" value="${person.id}" />
                    </c:url>
                    <c:url var="editCcUrl" value="/creditcard/showFormForUpdate?personId=${person.id}&creditCardId=${cc.id}" />
                    <td><a href="${editCcUrl}"><img src="${editUrlImg}" /></a></td>
                    <td><a href="${deleteUrl}"><img src="${deleteUrlImg}" /></a></td>
                </tr>
            </c:forEach>
                <c:url var="addCcUrl" value="/creditcard/showFormForAdd">
                    <c:param name="personId" value="${person.id}" />
                </c:url>
                <td><a href="${addCcUrl}">Add creditCard</a></td>
    </body>
</html>
