
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Save Page</title>
        <style>
            .error {
                color: #ff0000;
                font-style: italic;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <P><spring:message code="text.mainPage"/></p>
        <springForm:form method="POST" modelAttribute="employee" action="save.do">
            <table>
                <tr>
                    <td>Employee ID:</td>
                    <td><springForm:input path="id" /></td>
                    <td><springForm:errors path="id" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Employee Name:</td>
                    <td><springForm:input path="name" /></td>
                    <td><springForm:errors path="name" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Employee Role:</td>
                    <td><springForm:select path="role">
                            <springForm:option value="" label="Select Role" />
                            <springForm:option value="ceo" label="CEO" />
                            <springForm:option value="developer" label="Developer" />
                            <springForm:option value="manager" label="Manager" />
                        </springForm:select></td>
                    <td><springForm:errors path="role" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Employee Phone</td>
                    <td><springForm:input path="phone" /></td>
                    <td><springForm:errors path="phone" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Employee doj</td>
                    <td><springForm:input path="doj" /></td>
                    <td><springForm:errors path="doj" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Exotic type</td>
                    <td><springForm:input path="exoticType" /></td>
                    <td><springForm:errors path="exoticType" cssClass="error" /></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Save"></td>
                </tr>
            </table>

        </springForm:form>

    </body>
</html>
