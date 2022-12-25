package authorization.pack;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession httpSession = httpServletRequest.getSession(false);

        boolean log = httpSession != null && httpServletRequest.getParameter("login") != null && httpServletRequest.getParameter("password") != null ||
                httpSession != null && httpServletRequest.getParameter("a")!= null;

        if (log) {
            filterChain.doFilter(req, resp);
        } else {
            httpServletRequest.setAttribute("execut", "Log in first");
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest,httpServletResponse);
        }

    }

    @Override
    public void destroy() {

    }

}
