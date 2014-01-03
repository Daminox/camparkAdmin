<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <s:form action="loadHomePage" method="POST" namespace="/main">
            <s:submit>Charger les donnees</s:submit>
        </s:form>
    </body>
</html>