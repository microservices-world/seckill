package org.ms.common.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Objects;

/**
 * @author Zhenglai
 * @since 2019-04-14 17:01
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        var old = super.getParameter(name);
        if (StringUtils.isNoneBlank(old)) {
            old = StringEscapeUtils.escapeHtml4(old);
        }
        return old;
    }
}
