

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		Query<User> checkQuery = session.createQuery("from User where login = :login and password = :password");
		checkQuery.setParameter("login", request.getParameter("login"));
		checkQuery.setParameter("password", request.getParameter("haslo"));
		List<User> checkList = checkQuery.list();
		if(checkList.isEmpty()) {
			request.setAttribute("info", "Z³y login lub has³o!!!");
	        request.getRequestDispatcher("WEB-INF/rejestracjaWynik.jsp").forward(request, response);
		}else {
			User u = checkList.get(0);
	        @SuppressWarnings("unchecked")
			Query<LokatyBaza> query1 = session.createQuery("from LokatyBaza where telefon = :telefon");
	        query1.setParameter("telefon", u.getTelefon());
	        List<LokatyBaza> list1 = query1.list();
	        @SuppressWarnings("unchecked")
			Query<KredytyBaza> query2 = session.createQuery("from KredytyBaza where telefon = :telefon");
	        query2.setParameter("telefon", u.getTelefon());
	        List<KredytyBaza> list2 = query2.list();
	        session.close();
	        request.setAttribute("info", "Oto Twoja historia");
	        request.setAttribute("lokaty", list1);
	        request.setAttribute("kredyty", list2);
	        request.getRequestDispatcher("WEB-INF/rejestracjaWynik.jsp").forward(request, response);
		}
		
	}

}
