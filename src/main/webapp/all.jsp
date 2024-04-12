<%@ page import="org.klozevitz.lesson_08.model.Notepad" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="container">
        <div class="modal">
            <%List<Notepad> all = (List<Notepad>) request.getAttribute("allNotepads");%>

<%--    <% Notepad notepad = (Notepad) request.getAttribute("id");%>--%>

            <table class="responseTable" align="center">
                <thead>
                <tr>
                    <th class="cell">Id</th>
                    <th class="cell">Brand</th>
                    <th class="cell">Model</th>
                    <th class="cell">PageAmount</th>
                    <th class="cell">Cover</th>
                    <th class="cell">Country</th>
                    <th class="cell">PageType</th>
                </tr>
                </thead>
                <tbody>
                <%for (Notepad notepad: all) {%>

                <tr>
                    <td class="cell"><%=notepad.getId()%></td>
                    <td class="cell"><%=notepad.getBrand()%></td>
                    <td class="cell"><%=notepad.getModel()%></td>
                    <td class="cell"><%=notepad.getPageAmount()%></td>
                    <td class="cell"><%=notepad.getCover()%></td>
                    <td class="cell"><%=notepad.getCountry()%></td>
                    <td class="cell"><%=notepad.getPageType()%></td>
                </tr>

                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
