<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <body>
        <div id="content" class="content">
            <div id="msg">
                <%
                            String message, type;
                            message = (String) session.getAttribute("message");
                            type = (String) session.getAttribute("type");
                            session.removeAttribute("message");
                            session.removeAttribute("type");

                            if (message != null) {
                                out.println("<fieldset class=\"" + type + "\" onclick=\"closeMessageBox()\">");
                                String legend = "Undefined";
                                if (type == "information") {
                                    legend = "Information";
                                } else if (type == "critical") {
                                    legend = "Error";
                                } else if (type == "success") {
                                    legend = "Success";
                                } else if (type == "warning") {
                                    legend = "Warning";
                                }

                                out.println("<legend>" + legend + "</legend>");
                                out.println(message);
                                out.println("</fieldset>");
                            }

                %>
            </div>
            <p class="title">Search</p>
            <form id="formBusca" action="#" method="post" onsubmit="return validateFormBusca()">
                <table class="search" align="center" cellspacing="15px">
                    <tr>
                        <td align="left" colspan="2"><input class="textBox" type="text" id="parametro" name="parametro" size="80"/></td>
                        <td align="center">
                            <select name="filtro" id="filtro">
                                <option value="both"> ISBN/Journal </option>
                                <option value="isbn"> ISBN </option>
                                <option value="journal"> Journal </option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td  align="center">
                            <input type="submit" class="button" value="Search" name="search" />
                        </td>
                    </tr>
                </table>
            </form>
            <p class="text"> INSERIR TEXTO DE DICAS DE BUSCA AQUI</p>
        </div>
    </body>
</html>

