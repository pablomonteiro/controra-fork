package br.com.casamagalhaes.controra.security;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    private final String tokenHeaderName;

    public ApiKeyAuthFilter(String tokenHeaderName) {
        this.tokenHeaderName = tokenHeaderName;
        this.setContinueFilterChainOnUnsuccessfulAuthentication(false);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(tokenHeaderName);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }
}
