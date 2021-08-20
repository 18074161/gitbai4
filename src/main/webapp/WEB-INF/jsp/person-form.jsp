<%-- 
    Document   : person-form
    Created on : Jun 23, 2021, 9:39:44 AM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="savePerson" value="/person/savePerson" />
        <form:form modelAttribute="person" action="${savePerson}" method="POST">
            <form:hidden path="id" />
            <table>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td><form:label path="money">Money</form:label></td>
                    <td><form:input path="money" /></td>
                </tr>
            </table>
                <input type="submit" value="Save" />
        </form:form>
        
    </body>
</html>
