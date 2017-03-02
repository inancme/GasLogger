package com.mi.logger.gas.inancm.gaslogger;

/**
 * Created by metinin on 02.03.2017.
 */

public class GasLog {
    private String mileage, volume, money;

    public GasLog() {
    }

    public GasLog(String mileage, String volume, String money) {
        this.mileage = mileage;
        this.volume = volume;
        this.money = money;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String m) {
        this.mileage = m;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String v) {
        this.volume = v;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String m) {
        this.money = m;
    }
}
