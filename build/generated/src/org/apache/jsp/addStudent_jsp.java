package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import data.ConnManiDB;

public final class addStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Add Student</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    ");
      data.Student s = null;
      synchronized (request) {
        s = (data.Student) _jspx_page_context.getAttribute("s", PageContext.REQUEST_SCOPE);
        if (s == null){
          s = new data.Student();
          _jspx_page_context.setAttribute("s", s, PageContext.REQUEST_SCOPE);
          out.write("\n");
          out.write("        ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("s"), request);
          out.write("\n");
          out.write("    ");
        }
      }
      out.write("\n");
      out.write("    \n");
      out.write("    ");
 
        System.out.println("First Name: " + s.getFname());
    System.out.println("Last Name: " + s.getLname());
    System.out.println("Email: " + s.getEmail());
    System.out.println("Password: " + s.getPass());
    System.out.println("Gender: " + s.getGender());
    System.out.println("Country: " + s.getCountry());
        ConnManiDB cmdb = new ConnManiDB();
        Connection c = (Connection) request.getServletContext().getAttribute("dbConnection");
        int n = cmdb.insert(s, c);
        
        
        if (n > 0) {
            response.sendRedirect("successPage.jsp");
        } else {
            response.sendRedirect("errorPage.jsp");
        }
    
      out.write("\n");
      out.write("    ");
      out.print( n );
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
