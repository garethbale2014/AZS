/*******************************************************************************
 * Copyright (c) 2011, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 ******************************************************************************/
package org.eclipse.persistence.jpa.rs.exceptions;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.eclipse.persistence.jpa.rs.util.JPARSLogger;
import org.eclipse.persistence.jpa.rs.util.StreamingOutputMarshaller;

@Provider
public class ClassNotFoundExceptionMapper implements ExceptionMapper<ClassNotFoundException> {
    @Context
    private HttpHeaders headers;
    public Response toResponse(ClassNotFoundException exception){
        JPARSLogger.exception("jpars_caught_exception", new Object[]{}, exception);
        return Response.status(Status.BAD_REQUEST).type(StreamingOutputMarshaller.getResponseMediaType(headers)).build();
    }
    /*
    public Response toResponse(ClassNotFoundException exception, MediaType mediaType){
        JPARSLogger.exception("jpars_caught_exception", new Object[]{}, exception);
        return Response.status(Response.Status.BAD_REQUEST).
                entity(new ErrorResponse(1234, exception.getMessage())).type(mediaType).build();
    }*/
}
