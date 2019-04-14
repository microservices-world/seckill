package org.ms.common.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Zhenglai
 * @since 2019-04-14 17:51
 */
@WebFilter(filterName = "imageFilter", urlPatterns = "/imgs/*")
public class ImageFilter implements Filter {

    @Value("${domain.name}")
    private String domainName;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        var req = (HttpServletRequest)servletRequest;
        String refer = req.getHeader("Refer");
        if (StringUtils.isBlank(refer)) {
            req.getRequestDispatcher("/imgs/error.jpg").forward(req, servletResponse);
            return;
        }

        String domain = getDomain(refer);
        if (!Objects.equals(domain, domainName)) {
            req.getRequestDispatcher("/imgs/error.jpg").forward(req, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getDomain(String refer) {
        return null;
    }
}
