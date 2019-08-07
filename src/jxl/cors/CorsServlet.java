package jxl.cors;

import java.io.IOException;

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
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String PAGE = "/WEB-INF/cors/index.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		request.setAttribute("version", "1.0.2");
		request.setAttribute("allow_methods", CorsFilter.getAllow_methods().replaceAll(" ", "").split(","));
		request.setAttribute("allow_credentials", CorsFilter.getAllow_credentials());
		request.setAttribute("allow_origins", CorsFilter.getAllow_origins());
		request.getRequestDispatcher(PAGE).forward(request, response);
	}

}
