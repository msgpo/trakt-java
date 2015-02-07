package com.uwetrottmann.trakt.v2.services;

import com.uwetrottmann.trakt.v2.BaseTestCase;
import com.uwetrottmann.trakt.v2.exceptions.UnauthorizedException;
import com.uwetrottmann.trakt.v2.entities.Movie;
import com.uwetrottmann.trakt.v2.entities.Show;
import com.uwetrottmann.trakt.v2.enums.Extended;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecommendationsTest extends BaseTestCase {

    @Test
    public void test_movies() throws UnauthorizedException {
        List<Movie> movies = getTrakt().recommendations().movies(Extended.DEFAULT_MIN);
        assertThat(movies).isNotEmpty();
    }

    @Test
    public void test_shows() throws UnauthorizedException {
        List<Show> shows = getTrakt().recommendations().shows(Extended.DEFAULT_MIN);
        assertThat(shows).isNotEmpty();
    }

}
