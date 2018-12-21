/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.ws.rest;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Администратор
 */
@Provider
public class ServerLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOG = Logger.getLogger(ServerLoggingFilter.class.getName());
    
    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        String method = crc.getMethod();
        String uri = crc.getUriInfo().getAbsolutePath().toString();
        LOG.log(Level.INFO, "URI: {0}; Method: {1}", new Object[]{uri, method});
        for (String key : crc.getHeaders().keySet()) {
            List<String> value = crc.getHeaders().get(key);
            LOG.log(Level.INFO, "{0}={1}", new Object[]{key, value});
        }
    }

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        String method = crc.getMethod();
        String uri = crc.getUriInfo().getAbsolutePath().toString();
        LOG.log(Level.INFO, "For request URI: {0}; Method: {1}", new Object[]{uri, method});
        LOG.log(Level.INFO, "Response: ");
        for (String key : crc.getHeaders().keySet()) {
            List<String> value = crc.getHeaders().get(key);
            LOG.log(Level.INFO, "{0}={1}", new Object[]{key, value});
        }
    }
}
