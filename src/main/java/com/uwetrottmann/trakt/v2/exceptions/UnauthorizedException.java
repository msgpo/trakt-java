package com.uwetrottmann.trakt.v2.exceptions;

import retrofit.RetrofitError;

/**
 * Thrown if trakt returns HTTP status code 401 Unauthorized or 403 Forbidden, meaning that a valid access token must be provided.
 * This might also occur if the user has revoked your access token, and you need to login again.
 */
public class UnauthorizedException extends Exception {

    public UnauthorizedException(RetrofitError cause) {
        super("A valid access token must be provided", cause);
    }
}
