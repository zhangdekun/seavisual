package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Constant;
import dao.localDomain.model.User;

public class CheckLoginFilter implements Filter {

    private String loginMapping ="loginMapping" ;
    private final String LOGIN = "/login";
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String uri = ((HttpServletRequest) request).getRequestURI();
        if(uri.matches(loginMapping)){
            chain.doFilter(request, response);
        }else{
            User user = (User) session.getAttribute(Constant.SESSION_KEY_USER);
            if(user ==null){
                ((HttpServletResponse) response).sendRedirect(LOGIN);
            }else{
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // TODO Auto-generated method stub
        this.loginMapping = config.getInitParameter(loginMapping);
    }

    public String getLoginMapping() {
        return loginMapping;
    }

    public void setLoginMapping(String loginMapping) {
        this.loginMapping = loginMapping;
    }

}
