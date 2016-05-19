package edu.flight_discounter.special;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    public CustomBasicAuthenticationEntryPoint(final String realmName) {
        setRealmName(realmName);
    }

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authenticationException) throws IOException, ServletException {
        if (authenticationException instanceof BadCredentialsException) {
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getWriter(), new AuthenticationResponse());
            return;
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
    }
}