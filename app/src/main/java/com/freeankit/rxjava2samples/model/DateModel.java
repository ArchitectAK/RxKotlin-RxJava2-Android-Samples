package com.freeankit.rxjava2samples.model;

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 15/12/2017 (MM/DD/YYYY )
 */

public class DateModel implements Comparable<DateModel> {
    private Integer date;
    private Integer value;

    public DateModel(int date, int value) {
        this.date = date;
        this.value = value;
    }

    @Override
    public int compareTo(DateModel o) {
        return value.compareTo(o.value);
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
