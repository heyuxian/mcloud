package me.javaroad.mcloud.web.exception;

import java.net.URI;

/**
 * @author heyx
 */
public class ErrorConstants {
    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_VALIDATION = "error.validation";
    public static final String PROBLEM_BASE_URL = "http://localhost/problem";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/");

    public static final String UNAUTHORIZED = "error.unauthorized";
    public static final String INTERNAL_SERVER_ERROR = "error.unauthorized.internal_server_error";
}
