package br.edu.utfpr.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomServlet
 */
@WebServlet({ "/random", "/generate-number" })
public class RandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random r = new Random(Math.round(Math.random() * 100));
		Random randomSession = new Random(Math.random() * 10);
		
		request.getSession().setAttribute("randomSessionKey", randomSession);
		
		String address = "/WEB-INF/view/show-random.jsp";
		request.setAttribute("randomKey", r); 
		request.getRequestDispatcher(address).forward(request, response);
	}

	

}
