/*
 * Copyright 2012 - 2015 Manuel Laggner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uwetrottmann.trakt.v2.services;

import retrofit.http.Body;
import retrofit.http.POST;

import com.uwetrottmann.trakt.v2.entities.Login;
import com.uwetrottmann.trakt.v2.entities.UserToken;
import com.uwetrottmann.trakt.v2.exceptions.UnauthorizedException;

public interface Auth {
  /**
   * Request a user token via login.
   */
  @POST("/auth/login")
  UserToken getUserToken(@Body Login login) throws UnauthorizedException;
}
