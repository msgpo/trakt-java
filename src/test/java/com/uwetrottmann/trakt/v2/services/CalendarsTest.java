package com.uwetrottmann.trakt.v2.services;

import com.uwetrottmann.trakt.v2.BaseTestCase;
import com.uwetrottmann.trakt.v2.entities.CalendarEntry;
import com.uwetrottmann.trakt.v2.exceptions.LoginException;
import com.uwetrottmann.trakt.v2.exceptions.UnauthorizedException;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarsTest extends BaseTestCase {

  // week which has show premiere (and therefore season premiere)
  private static final String TEST_START_DATE = "2014-09-01";
  private static final int    TEST_DAYS       = 7;

  @Test
  public void test_shows() throws UnauthorizedException, LoginException {
    // do unauthenticated call
    getTrakt().setLoginData(null, null);

    Map<DateTime, List<CalendarEntry>> shows = getTrakt().calendars().shows(TEST_START_DATE, TEST_DAYS);
    assertShowCalendar(shows);

    // restore auth
    getTrakt().setLoginData(TEST_USERNAME, TEST_PASSWORD);
  }

  @Test
  public void test_newShows() throws UnauthorizedException, LoginException {
    // do unauthenticated call
    getTrakt().setLoginData(null, null);

    Map<DateTime, List<CalendarEntry>> shows = getTrakt().calendars().newShows(TEST_START_DATE, TEST_DAYS);
    assertShowCalendar(shows);

    // restore auth
    getTrakt().setLoginData(TEST_USERNAME, TEST_PASSWORD);
  }

  @Test
  public void test_seasonPremieres() throws UnauthorizedException, LoginException {
    // do unauthenticated call
    getTrakt().setLoginData(null, null);

    Map<DateTime, List<CalendarEntry>> shows = getTrakt().calendars().seasonPremieres(TEST_START_DATE, TEST_DAYS);
    assertShowCalendar(shows);

    // restore auth
    getTrakt().setLoginData(TEST_USERNAME, TEST_PASSWORD);
  }

  @Test
  public void test_movies() throws UnauthorizedException, LoginException {
    // do unauthenticated call
    getTrakt().setLoginData(null, null);

    Map<DateTime, List<CalendarEntry>> movies = getTrakt().calendars().movies("2014-05-01", 30);
    assertThat(movies.keySet()).doesNotContainNull();
    for (List<CalendarEntry> entries : movies.values()) {
      for (CalendarEntry entry : entries) {
        assertThat(entry.airs_at).isNull();
        assertThat(entry.episode).isNull();
        assertThat(entry.show).isNull();
        assertThat(entry.movie).isNotNull();
      }
    }

    // restore auth
    getTrakt().setLoginData(TEST_USERNAME, TEST_PASSWORD);
  }

  private void assertShowCalendar(Map<DateTime, List<CalendarEntry>> shows) {
    assertThat(shows.keySet()).doesNotContainNull();
    for (List<CalendarEntry> entries : shows.values()) {
      for (CalendarEntry entry : entries) {
        assertThat(entry.airs_at).isNotNull();
        assertThat(entry.episode).isNotNull();
        assertThat(entry.show).isNotNull();
        assertThat(entry.movie).isNull();
      }
    }
  }
}
