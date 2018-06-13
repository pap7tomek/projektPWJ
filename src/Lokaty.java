

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
		request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double k = 0, r = 0, n = 0;
		int m = 0;
		double m1 = 1;
		Session session = HibernateUtil.getSessionFactory().openSession();
		LokatyBaza l = new LokatyBaza();
		l.setKwota(Double.parseDouble(request.getParameter("kwota")));
		l.setOprocentowanie(Double.parseDouble(request.getParameter("oprocentowanie")));
		l.setOkres(Integer.parseInt(request.getParameter("okres")));
		l.setOkres2(Integer.parseInt(request.getParameter("okres2")));
		l.setKapitalizacja(Integer.parseInt(request.getParameter("kapitalizacja")));
		
		l.setTelefon(request.getParameter("telefon"));
		
        
        request.setAttribute("kwota", Double.parseDouble(request.getParameter("kwota")));
        request.setAttribute("oprocentowanie", Double.parseDouble(request.getParameter("oprocentowanie")));
        request.setAttribute("okres", Integer.parseInt(request.getParameter("okres")));
        request.setAttribute("okres2", Integer.parseInt(request.getParameter("okres2")));
        request.setAttribute("kapitalizacja", Integer.parseInt(request.getParameter("kapitalizacja")));
        request.setAttribute("telefon", request.getParameter("telefon"));
        try {
            k = Double.parseDouble(request.getParameter("kwota"));
        } catch (Exception e) {
            k = 0;
        }
        try {
            r = Double.parseDouble(request.getParameter("oprocentowanie"))/100;
        } catch (Exception e) {
            r = 0;
        }
        try {
            m = Integer.parseInt(request.getParameter("kapitalizacja"));
        } catch (Exception e) {
            m = 0;
        }
        if(m == 1) {
        	m1 = 365/15;
        }
        if(m == 2) {
        	m1 = 12;
        }
        if(m == 3) {
        	m1 = 4;
        }
        if(m == 4) {
        	m1 = 2;
        }
        if(Integer.parseInt(request.getParameter("okres2")) == 1) {
        	try {
                n = Double.parseDouble(request.getParameter("okres"));
            } catch (Exception e) {
                n = 1;
            }
        }
        if(Integer.parseInt(request.getParameter("okres2")) == 2) {
        	try {
                n = Double.parseDouble(request.getParameter("okres"))/12;
            } catch (Exception e) {
                n = 1;
            }
        }
        if(Integer.parseInt(request.getParameter("okres2")) == 3) {
        	try {
                n = Double.parseDouble(request.getParameter("okres"))/52;
            } catch (Exception e) {
                n = 1;
            }
        }
        if(Integer.parseInt(request.getParameter("okres2")) == 4) {
        	try {
                n = Double.parseDouble(request.getParameter("okres"))/365;
            } catch (Exception e) {
                n = 1;
            }
        }
        double wynik = k*Math.pow((1+r/m1),n*m1);
        double podatek = (wynik - k) * 0.19;
        double zysk = wynik - podatek - k;
        request.setAttribute("podatek", String.format("%.2f", podatek));
        request.setAttribute("zysk", String.format("%.2f", zysk));
        request.setAttribute("miec", String.format("%.2f", wynik - podatek));
        l.setWynik(String.format("%.2f", wynik - podatek));
		session.beginTransaction();  
        session.persist(l);
        session.getTransaction().commit(); 
        session.close();
		request.getRequestDispatcher("WEB-INF/lokatyWynik.jsp").forward(request, response);
	}

}
