

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

/**
 * Servlet implementation class Lokaty
 */
@WebServlet("/Lokaty")
public class Lokaty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lokaty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("telefon"));
		String telefon = request.getParameter("telefon");
		request.setAttribute("telefon", telefon);
		request.getRequestDispatcher("WEB-INF/lokaty.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		LokatyBaza l = new LokatyBaza();
		l.setKwota(Double.parseDouble(request.getParameter("kwota")));
		l.setOprocentowanie(Double.parseDouble(request.getParameter("oprocentowanie")));
		l.setOkres(Integer.parseInt(request.getParameter("okres")));
		l.setOkres2(Integer.parseInt(request.getParameter("okres2")));
		l.setKapitalizacja(Integer.parseInt(request.getParameter("kapitalizacja")));
		l.setTelefon(request.getParameter("telefon"));
		session.beginTransaction();  
        session.persist(l);
        session.getTransaction().commit(); 
        session.close();
	}

}
