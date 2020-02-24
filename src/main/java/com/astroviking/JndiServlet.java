package com.astroviking;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

public class JndiServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    processRequest(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    processRequest(request, response);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    try {
      // Get a reference to the context
      InitialContext ctx = new InitialContext();
      // Notice I had to prepend "java:/comp/env" to the resource name "jdbc/TestDB"
      DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/TestDB");

      if (dataSource != null) System.out.println("DataSource retrieved!");

    } catch (NamingException e) {
      e.printStackTrace();
    }
    response.getWriter().write("<html><h1>Hello from JNDI example</h1></html>");
  }
}
