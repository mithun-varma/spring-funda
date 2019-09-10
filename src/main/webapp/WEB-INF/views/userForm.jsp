
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Save Page</title>
        <style>
            .error {
                color: #ff0000;
                font-style: italic;
                font-weight: bold;
            }
        </style>
    </head>
    <body>

        <strong>status :${message}</strong><br>
        <c:if test="${not empty errors}">
            <c:forEach items="${errors}" var="error">
               ${error}
            </c:forEach>
        </c:if>
        <springForm:form method="POST" modelAttribute="userForm" action="formSubmit">
            <table>
                <tr>
                    <td>Email</td>
                    <td><springForm:input path="email" /></td>
                    <td><springForm:errors path="email" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Verify Email:</td>
                    <td><springForm:input path="verifyEmail" /></td>
                    <td><springForm:errors path="verifyEmail" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><springForm:input path="password" /></td>
                    <td><springForm:errors path="password" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Verify Password</td>
                    <td><springForm:input path="verifyPassword" /></td>
                    <td><springForm:errors path="verifyPassword" cssClass="error" /></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Save User"></td>
                </tr>
            </table>
        </springForm:form>

    </body>
</html>

