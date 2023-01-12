package com.travactory.recruitment.junior.model;

public class FlightDuration {
    private final Long days;
    private final Long hours;
    private final Long minutes;

    public FlightDuration(final Long days, final Long hours, final Long minutes) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }

    public Long getDays() {
        return this.days;
    }

    public Long getHours() {
        return this.hours;
    }

    public Long getMinutes() {
        return this.minutes;
    }
}
