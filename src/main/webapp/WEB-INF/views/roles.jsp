<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <body>
        <h2>Spring Security Example</h2>
        <p>Time: ${time}<br/>
        <p>URI: ${uri} <br/>
            User :  ${user} <br/>
            roles:  ${roles} <br/>
        </p>
        <form action="/logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>