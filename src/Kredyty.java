

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

/**
 * Servlet implementation class Kredyty
 */
@WebServlet("/Kredyty")
public class Kredyty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kredyty() {
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
		int rodzaj = 0;
		double n = 0, k = 0, opr = 0, q = 0;
		List <String> lista = new ArrayList<String>();
		double suma = 0;
		double rata = 0;
		try {
			rodzaj = Integer.parseInt(request.getParameter("typ"));
	    } catch (Exception e) {
	    	rodzaj = 1;
	    }
		try {
			k = Double.parseDouble(request.getParameter("kwota"));
	    } catch (Exception e) {
	    	k = 0;
	    }
		try {
			n = Double.parseDouble(request.getParameter("okres"))*12;
	    } catch (Exception e) {
	    	n = 1;
	    }
		try {
			opr = Double.parseDouble(request.getParameter("oprocentowanie"))/100;
	    } catch (Exception e) {
	    	opr = 0;
	    }
		if(rodzaj == 1) {
			q = 1 + (opr/12);
			rata = (k*Math.pow(q, n)*(q-1))/(Math.pow(q, n)-1);
			suma = n*rata;
		}else {
			for(int i = 1; i <= n; i++) {
				rata = k/n*(1+(n-i+1)*opr/12);
				suma += rata;
				lista.add(String.format("%.2f", rata));
			}
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		KredytyBaza l = new KredytyBaza();
		l.setKwota(k);
		l.setOprocentowanie(opr*100);
		l.setOkres(n/12);
		l.setTyp(rodzaj);
		l.setTelefon(request.getParameter("telefon"));
		session.beginTransaction();  
        session.persist(l);
        session.getTransaction().commit(); 
        session.close();
		request.setAttribute("typ", rodzaj);
		request.setAttribute("lista", lista);
        request.setAttribute("rata", String.format("%.2f", rata));
        request.setAttribute("suma", String.format("%.2f", suma));
        request.setAttribute("kwota",k);
        request.getRequestDispatcher("WEB-INF/kredytyWynik.jsp").forward(request, response);
	}

}
