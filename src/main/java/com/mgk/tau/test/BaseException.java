package com.mgk.tau.test;

import okhttp3.internal.http2.ErrorCode;

/**
 * The BaseException wraps all checked standard Java exception and enriches them with a custom error code.
 * You can use this code to retrieve localized error messages and to link to our online documentation.
 *
 * @author Manoj Kolhe
 */
public class BaseException extends RuntimeException {

    private final ErrorCode errorCode;

    public BaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
