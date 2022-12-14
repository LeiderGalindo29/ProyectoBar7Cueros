package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("      \n");
      out.write("      <script src=\"https://kit.fontawesome.com/6131ecdde6.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"assets/css/index.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"grid-container\" >     \n");
      out.write("            <div class=\"contenido\">\n");
      out.write("                <div class=\"formulario\" id=\"filter\">     \n");
      out.write("                    <form action=\"Usuario\" method=\"POST\">\n");
      out.write("                        <h1>Iniciar sesi??n</h1>\n");
      out.write("                        <div id=\"input\">\n");
      out.write("                            <label>Usuario:</label>\n");
      out.write("                            <input type=\"text\" name=\"usuario_nombre\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"input\">\n");
      out.write("                            <label>Contrase??a:</label>\n");
      out.write("                            <input type=\"password\" name=\"usuario_password\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"input\">\n");
      out.write("\n");
      out.write("                            <button>Ingresar</button>\n");
      out.write("                            <input type=\"hidden\" value=\"1\" name=\"valor\" >\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                ");

                if (request.getAttribute("Error") != null) {
      out.write("\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                ");
} else {
      out.write("\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Exito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                ");
}
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <script src=\"js/acciones.js\"></script>\n");
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
