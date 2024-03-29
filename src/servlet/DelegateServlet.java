/**
 * Created by xcheng at 2019/3/10
 */
package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class DelegateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = (String)req.getAttribute("method");
        try {
            req.setCharacterEncoding("utf-8");
            Method m = this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            String redirect = m.invoke(this,req,resp).toString();
            if(redirect.startsWith("@")){
                resp.sendRedirect(redirect.substring(1));
            }else if(redirect.startsWith("%"))
                resp.getWriter().print(redirect.substring(1));
            else
                req.getRequestDispatcher(redirect).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}