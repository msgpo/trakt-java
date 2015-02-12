package com.uwetrottmann.trakt.v2.entities;

import org.joda.time.DateTime;

public class BaseEpisode {

    public Integer number;

    /** collection */
    public DateTime collected_at;
    /** watched */
    public DateTime last_watched_at;
    public Integer plays;
    /** progress */
    public Boolean completed;

}
