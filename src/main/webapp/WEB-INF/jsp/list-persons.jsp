<%-- 
    Document   : list-persons
    Created on : Jun 23, 2021, 9:12:39 AM
    Author     : Admin
--%>


<!DOCTYPE html><%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <th>First Name</th>
                <th>Last Name</th>
                <th>Money</th>
                
                <th colspan="2"></th>
                <th>CC view</th>
            </tr>
            <c:forEach items="${persons}" var="person">
                <tr>
                    <td><c:out value="${person.id}"/></td>
                    <td><c:out value="${person.firstName}"/></td>
                    <td><c:out value="${person.lastName}"/></td>
                    <td><c:out value="${person.money}"/></td>
                    <c:url var="deleteUrl" value="/person/delete">
                        <c:param name="personId" value="${person.id}" />
                    </c:url>
                    <c:url var="editUrl" value="/person/showFormForUpdate">
                        <c:param name="personId" value="${person.id}" />
                    </c:url>
                    <c:url var="viewUrl" value="/creditcard/list">
                        <c:param name="personId" value="${person.id}" />
                    </c:url>
                    <td><a href="${editUrl}"><img src="${editUrlImg}" /></a></td>
                    <td><a href="${deleteUrl}"><img src="${deleteUrlImg}" /></a></td>
                    <td><a href="${viewUrl}"><img src="${viewUrlImg}" /></a></td>
                </tr>
            </c:forEach>
            
        </table>
        <c:url var="addPerson" value="/person/showFormForAdd" />
        <p><a href="${addPerson}">Create New person</a></p>
    </body>
</html>
