package com.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.connection.*;
import com.pojo.AddProduct;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(com.pojo.AddProduct.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(builder.build());
		
		PrintWriter out = response.getWriter();
		String c = request.getParameter("count");
		String name = request.getParameter("name");
		
		if((name.equalsIgnoreCase("") || name == null) || (c.equalsIgnoreCase("") || c == null)) {
			out.println("<h1 align='center'><span style='color:red'>Item Not Added</span></h1>");
		}else {
		
		int count = Integer.parseInt(c);
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		AddProduct p1 = new AddProduct(name, count);
		session.save(p1);
		trans.commit();
		session.close();
		
		out.println("<h1 align='center'><span style='color:green'>Item Sussessfully Added</span></h1>");
		}//end of 'if statement'
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
