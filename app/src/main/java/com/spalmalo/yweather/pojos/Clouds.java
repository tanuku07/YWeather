package com.spalmalo.yweather.pojos;

import com.google.gson.annotations.Expose;

public class Clouds {

    @Expose
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

}
