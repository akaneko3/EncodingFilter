package jp.mydns.akanekodou.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.Locale;

public class EncodingFilter implements Filter {
    private String _encoding;
    private String _language;

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(_encoding);
        response.setCharacterEncoding(_encoding);
        response.setLocale(new Locale(_language));

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        _encoding = config.getInitParameter("encoding");
        _language = config.getInitParameter("language");
    }
}
