package com.uwetrottmann.trakt.v2;

import com.uwetrottmann.trakt.v2.entities.Login;
import com.uwetrottmann.trakt.v2.entities.UserToken;
import com.uwetrottmann.trakt.v2.services.Auth;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test should NOT be run with the regular test suite. It requires a valid, temporary (!) auth code to be set.
 */
public class AuthTest extends BaseTestCase {

  @Test
  public void test_getAccessToken() {
    try{
      Auth auth = getTrakt().auth();
      UserToken token = auth.getUserToken(new Login(TEST_USERNAME, TEST_PASSWORD));
      assertThat(token).isNotNull();
      assertThat(token.token).isNotNull();
      assertThat(token.token).isNotEmpty();
    } catch (Exception e){
      e.printStackTrace();
      Assert.fail();
    }
  }
}
