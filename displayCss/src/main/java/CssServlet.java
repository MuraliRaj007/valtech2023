 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@WebServlet("/DisplayCSS")
public class CssServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("cssFile");
		InputStream fileContent = filePart.getInputStream();
		Map<String, String> cssMap = readCSSFile(fileContent);

		request.setAttribute("cssMap", cssMap);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	private Map<String, String> readCSSFile(InputStream fileContent) {
        Map<String, String> cssMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent))) {
            String line;
            String cssClass = null;

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\{}", " ");

                // Check if the line contains a CSS class
                if (line.startsWith(".")) {
                    if (cssClass != null) {
                        cssMap.put(cssClass, cssMap.get(cssClass).trim());
                    }
                    cssClass = line.substring(1); 
                    cssMap.put(cssClass, "");                
                    } else if (cssClass != null) {
                    cssMap.put(cssClass, cssMap.get(cssClass) + " " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cssMap;
    }

}
