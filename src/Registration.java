

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/rejestracja.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		Query<User> checkQuery = session.createQuery("from User where telefon = :telefon");
		checkQuery.setParameter("telefon", request.getParameter("telefon"));
		List<User> checkList = checkQuery.list();
		if(checkList.isEmpty()) {
			
		}
		User l = new User();
		l.setLogin(request.getParameter("login"));
		l.setPassword(request.getParameter("haslo"));
		l.setEmail(request.getParameter("email"));
		l.setTelefon(request.getParameter("telefon"));
		session.beginTransaction();  
        session.persist(l);
        session.getTransaction().commit(); 
        @SuppressWarnings("unchecked")
		Query<LokatyBaza> query = session.createQuery("from LokatyBaza where telefon = :telefon");
        query.setParameter("telefon", request.getParameter("telefon"));
        List<LokatyBaza> list = query.list();
        session.close();
        request.setAttribute("lista", list);
        request.getRequestDispatcher("WEB-INF/rejestracjaWynik.jsp").forward(request, response);
	}

}
