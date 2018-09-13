package br.edu.utfpr.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowNameServlet
 */
@WebServlet("/show-name")
public class ShowNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//l� o par�metro do formul�rio
		String name = request.getParameter("name-person");
		//endere�o do Servlet para redirect-after-post, o mesmo servlet
		String address = "show-name";
		//guarda o nome na sess�o, pois no redirect � uma nova requisi��o
		request.getSession().setAttribute("nameKey", name);
		response.sendRedirect(address);		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Pega a requisi��o de redirecionamento, que � GET, e faz
		 * o encaminhamento para a vis�o, que � o JSP.
		 */
		String address = "/WEB-INF/view/show-name.jsp";
		String name = (String)req.getSession().getAttribute("nameKey");
		req.getRequestDispatcher(address).forward(req, resp);
	}

}
