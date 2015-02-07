package com.uwetrottmann.trakt.v2.exceptions;

import retrofit.RetrofitError;

public class LoginException extends Exception {

  public LoginException(String errorText) {
    super(errorText);
  }

  public LoginException(RetrofitError cause) {
    super("Could not login", cause);
  }
}
