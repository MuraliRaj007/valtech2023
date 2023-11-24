<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>CSS Viewer</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
	<%! 
	public static String convertHexToRGB(String attribute) {
        Pattern pattern = Pattern.compile("#[0-9A-Fa-f]{6}");
        Matcher matcher = pattern.matcher(attribute);

        while (matcher.find()) {
            String hexColor = matcher.group();
            String rgbColor = hexToRgb(hexColor);
            attribute = attribute.replace(hexColor, rgbColor);
        }

        return attribute;
    }

    public static String hexToRgb(String hex) {
        int r = Integer.parseInt(hex.substring(1, 3), 16);
        int g = Integer.parseInt(hex.substring(3, 5), 16);
        int b = Integer.parseInt(hex.substring(5, 7), 16);
        return "rgb(" + r + ", " + g + ", " + b + ")";
    }
	%>
    <div class="container mt-5">
        <%-- Display CSS class and converted attribute mappings --%>
        <%
        Map<String, String> cssMap = (Map<String, String>) request.getAttribute("cssMap");
        if (cssMap != null) {
            for (String cssClass : cssMap.keySet()) {
        %>
            <div class="card mb-3">
                <div class="card-header">
                    <h5 class="card-title">Class: <%= cssClass.replace("{", "") %></h5>
                </div>
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted">Attribute:</h6>
                    <ul class="list-group">
                        <% 
                        String attributes = cssMap.get(cssClass);
                        attributes = attributes.replace("}", "").trim();
                        String[] attributeArray = attributes.split(";");
                        for (String attribute : attributeArray) {
                            if (!attribute.trim().isEmpty()) {
                            	String convertedAttribute=convertHexToRGB(attribute);
                        %>
                            <li class="list-group-item"><%= convertedAttribute.trim() %></li>
                        <%
                            }
                        }
                        %>
                    </ul>
                </div>
            </div>
        <%
            }
        } else {
        %>
            <p class="alert alert-warning">cssMap is null</p>
        <%
        }
        %>
    </div>

</body>
</html>
