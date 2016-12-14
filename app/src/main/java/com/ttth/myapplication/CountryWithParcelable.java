package com.ttth.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hang on 12/14/2016.
 */

public class CountryWithParcelable implements Parcelable {
    private String name;
    private String capital;
    private int population;


    public CountryWithParcelable(String name, String capital, int population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.capital);
        dest.writeInt(this.population);
    }

    protected CountryWithParcelable(Parcel in) {
        this.name = in.readString();
        this.capital = in.readString();
        this.population = in.readInt();
    }

    public static final Parcelable.Creator<CountryWithParcelable> CREATOR = new Parcelable.Creator<CountryWithParcelable>() {
        @Override
        public CountryWithParcelable createFromParcel(Parcel source) {
            return new CountryWithParcelable(source);
        }

        @Override
        public CountryWithParcelable[] newArray(int size) {
            return new CountryWithParcelable[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "CountryWithParcelable{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                '}';
    }
}
