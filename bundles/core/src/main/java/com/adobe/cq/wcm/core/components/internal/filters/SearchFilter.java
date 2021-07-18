package com.adobe.cq.wcm.core.components.internal.filters;

import com.adobe.cq.wcm.core.components.internal.form.FormConstants;
import com.adobe.cq.wcm.core.components.internal.servlets.CoreFormHandlingServlet;
import com.adobe.cq.wcm.core.components.internal.servlets.SearchResultServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.*;

import java.io.IOException;

import static org.apache.sling.engine.EngineConstants.*;



@Component(
    service = {Servlet.class, Filter.class},
    property = {
        "sling.servlet.resourceTypes=cq/Page",
        "sling.servlet.methods=GET",
        "sling.servlet.selectors="+SearchFilter.SEARCH_FILTER,
        "sling.servlet.extensions=json",
        "sling.filter.scope=request",
        "service.ranking:Integer=100",
    }
)
public class SearchFilter implements Filter {

    protected static  final String SEARCH_FILTER = "searchresults";
    private static final String SEARCH_SERVLET_PATH = ""; // update accordingly

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(SEARCH_SERVLET_PATH);
        requestDispatcher.forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
