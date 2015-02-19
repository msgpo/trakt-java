package com.uwetrottmann.trakt.v2.exceptions;

import retrofit.RetrofitError;

/**
 * Thrown when we could login successfully, but did not receive a valid user token for token auth
 */
public class LoginException extends Exception {

    private static final long serialVersionUID = 1L;

    public LoginException(String errorText) {
        super(errorText);
    }

    public LoginException(RetrofitError cause) {
        super("Could not login", cause);
    }
}
