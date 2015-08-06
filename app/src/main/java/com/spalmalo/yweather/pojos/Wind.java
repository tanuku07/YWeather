package com.spalmalo.yweather.pojos;

import com.google.gson.annotations.Expose;

public class Wind {

    @Expose
    private double speed;
    @Expose
    private double deg;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

}
