package com.test.amaro.amarotest.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jaiber on 1/19/18.
 */

public class Size implements Parcelable {

    private Boolean available;
    private String size;
    private String sku;

    /**
     * No args constructor for use in serialization
     *
     */
    public Size() {
    }

    /**
     *
     * @param available
     * @param sku
     * @param size
     */
    public Size(Boolean available, String size, String sku) {
        super();
        this.available = available;
        this.size = size;
        this.sku = sku;
    }

    protected Size(Parcel in) {
        byte tmpAvailable = in.readByte();
        available = tmpAvailable == 0 ? null : tmpAvailable == 1;
        size = in.readString();
        sku = in.readString();
    }

    public static final Creator<Size> CREATOR = new Creator<Size>() {
        @Override
        public Size createFromParcel(Parcel in) {
            return new Size(in);
        }

        @Override
        public Size[] newArray(int size) {
            return new Size[size];
        }
    };

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (available == null ? 0 : available ? 1 : 2));
        parcel.writeString(size);
        parcel.writeString(sku);
    }
}
