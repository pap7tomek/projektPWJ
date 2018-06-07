

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;



/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Logs l = new Logs();
		l.setFirstName(request.getParameter("imie"));
		l.setLastName(request.getParameter("nazwisko"));
		l.setPhoneNumber(request.getParameter("telefon"));
		l.setType(Integer.parseInt(request.getParameter("type")));
		session.beginTransaction();  
        session.persist(l);
        session.getTransaction().commit(); 
        session.close();
        request.setAttribute("telefon", l.getPhoneNumber());
		request.getRequestDispatcher("WEB-INF/lokaty.jsp").forward(request, response);
	}

}
