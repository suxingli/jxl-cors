package jxl.cors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.cors.filter.CorsFilter;

/**
 * 跨域Servlet
 * @author 苏行利
 * @date 2019-08-07 17:38:08
 */
@WebServlet(name = "cors", value = "/cors", loadOnStartup = 1)
public class CorsServlet extends HttpServlet {
	private static final long serialVersionUID = -2522590307790871960L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String allow_methods = CorsFilter.getAllow_methods();
		String allow_credentials = CorsFilter.getAllow_credentials();
		List<String> allow_origins = CorsFilter.getAllow_origins();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0, len = allow_origins.size(); i < len; i++) {
			buffer.append(allow_methods).append(" ").append(allow_credentials).append(" ").append(allow_origins.get(i)).append("\n");
		}
		PrintWriter writer = response.getWriter();
		writer.write(buffer.toString());
		writer.close();
	}

}
