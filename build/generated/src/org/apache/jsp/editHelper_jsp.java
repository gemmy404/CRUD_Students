package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import data.Student;
import java.sql.Connection;
import data.ConnManiDB;

public final class editHelper_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <title>Edit</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Connection c = (Connection) request.getServletContext().getAttribute("dbConnection");
            int id = Integer.parseInt(request.getParameter("id"));
            ConnManiDB cmdb = new ConnManiDB();
            Student s = cmdb.getRecord(id, c);
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
 if (s != null) { 
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <form action=\"editStudent.jsp\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"ID\">ID</label>\n");
      out.write("                                    <input type=\"text\" id=\"ID\" name=\"id\" class=\"form-control\" value=\"");
      out.print( s.getId() );
      out.write("\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <label for=\"firstName\">First Name</label>\n");
      out.write("                                        <input type=\"text\" id=\"firstName\" name=\"firstName\" class=\"form-control\" value=\"");
      out.print( s.getFname() );
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <label for=\"lastName\">Last Name</label>\n");
      out.write("                                        <input type=\"text\" id=\"lastName\" name=\"lastName\" class=\"form-control\" value=\"");
      out.print( s.getLname() );
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"email\">Email</label>\n");
      out.write("                                    <input type=\"email\" id=\"email\" name=\"email\" class=\"form-control\" value=\"");
      out.print( s.getEmail() );
      out.write("\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"psw\">Password</label>\n");
      out.write("                                    <input type=\"password\" id=\"psw\" name=\"psw\" class=\"form-control\" value=\"");
      out.print( s.getPass() );
      out.write("\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Gender</label><br>\n");
      out.write("                                    <div class=\"form-check form-check-inline\">\n");
      out.write("                                        <input type=\"radio\" id=\"male\" name=\"gender\" value=\"male\" class=\"form-check-input\">\n");
      out.write("                                        <label for=\"male\" class=\"form-check-label\">Male</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-check form-check-inline\">\n");
      out.write("                                        <input type=\"radio\" id=\"female\" name=\"gender\" value=\"female\" class=\"form-check-input\">\n");
      out.write("                                        <label for=\"female\" class=\"form-check-label\">Female</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"country\">Country</label>\n");
      out.write("                                    <select id=\"country\" name=\"country\" class=\"form-control\">\n");
      out.write("                                        <option value=\"egy\">Egypt</option>\n");
      out.write("                                        <option value=\"pal\">Palestine</option>\n");
      out.write("                                        <option value=\"sud\">Sudan</option>\n");
      out.write("                                        <option value=\"syr\">Syria</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success\">Edit <i class=\"bi bi-person-fill-add\"></i></button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 } else { response.sendRedirect("errorPage.jsp"); } 
      out.write("\n");
      out.write("    </body>\n");
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
