package com.test.amaro.amarotest.Model;

/**
 * Created by jaiber on 1/19/18.
 */

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.Gson;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product implements Parcelable{

    private String name;
    private String style;
    private String code_color;
    private String colorSlug;
    private String color;
    private Boolean onSale;
    private String regular_price;
    private String actual_price;
    private String discountPercentage;
    private String installments;
    private String image;
    private List<Size> sizes = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    /**
     *
     * @param sizes
     * @param actual_price
     * @param onSale
     * @param style
     * @param color
     * @param colorSlug
     * @param discountPercentage
     * @param name
     * @param image
     * @param regular_price
     * @param codeColor
     * @param installments
     */
    public Product(String name, String style, String codeColor, String colorSlug, String color, Boolean onSale, String regular_price, String actual_price, String discountPercentage, String installments, String image, List<Size> sizes) {
        super();
        this.name = name;
        this.style = style;
        this.code_color = codeColor;
        this.colorSlug = colorSlug;
        this.color = color;
        this.onSale = onSale;
        this.regular_price = regular_price;
        this.actual_price = actual_price;
        this.discountPercentage = discountPercentage;
        this.installments = installments;
        this.image = image;
        this.sizes = sizes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCodeColor() {
        return code_color;
    }

    public void setCodeColor(String codeColor) {
        this.code_color = codeColor;
    }

    public String getColorSlug() {
        return colorSlug;
    }

    public void setColorSlug(String colorSlug) {
        this.colorSlug = colorSlug;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public String getRegularPrice() {
        return regular_price;
    }

    public void setRegularPrice(String regularPrice) {
        this.regular_price = regularPrice;
    }

    public String getActualPrice() {
        return actual_price;
    }

    public void setActualPrice(String actualPrice) {
        this.actual_price = actualPrice;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }


    // Decodes array of business json results into business model objects
    public static ArrayList<Product> fromJson(JSONArray jsonArray) {

        ArrayList<Product> productList = new ArrayList<Product>(jsonArray.length());

        Gson gson = new Gson();
        Product[] data = gson.fromJson(jsonArray.toString(), Product[].class);
        //Log.d(TAG, ""+data.length);

        productList = new ArrayList<Product>(Arrays.asList(data));

        return productList;
    }


    protected Product(Parcel in) {
        name = in.readString();
        style = in.readString();
        code_color = in.readString();
        colorSlug = in.readString();
        color = in.readString();
        byte tmpOnSale = in.readByte();
        onSale = tmpOnSale == 0 ? null : tmpOnSale == 1;
        regular_price = in.readString();
        actual_price = in.readString();
        discountPercentage = in.readString();
        installments = in.readString();
        image = in.readString();
        //in.readList(sizes, null);
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(style);
        parcel.writeString(code_color);
        parcel.writeString(colorSlug);
        parcel.writeString(color);
        parcel.writeByte((byte) (onSale == null ? 0 : onSale ? 1 : 2));
        parcel.writeString(regular_price);
        parcel.writeString(actual_price);
        parcel.writeString(discountPercentage);
        parcel.writeString(installments);
        parcel.writeString(image);
        //parcel.writeList(sizes);

        //Log.d("TAG", "patrcel: "+parcel.getClass().toString());

    }
}