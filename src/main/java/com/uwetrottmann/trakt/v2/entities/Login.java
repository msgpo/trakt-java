package com.uwetrottmann.trakt.v2.entities;

public class Login {
  public String login;
  public String password;

  public Login(String username, String password) {
    this.login = username;
    this.password = password;
  }
}
