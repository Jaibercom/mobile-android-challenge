package com.test.amaro.amarotest.Model;

/**
 * Created by jaiber on 1/19/18.
 */

import java.util.List;

public class Product {

    private String name;
    private String style;
    private String codeColor;
    private String colorSlug;
    private String color;
    private Boolean onSale;
    private String regularPrice;
    private String actualPrice;
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
     * @param actualPrice
     * @param onSale
     * @param style
     * @param color
     * @param colorSlug
     * @param discountPercentage
     * @param name
     * @param image
     * @param regularPrice
     * @param codeColor
     * @param installments
     */
    public Product(String name, String style, String codeColor, String colorSlug, String color, Boolean onSale, String regularPrice, String actualPrice, String discountPercentage, String installments, String image, List<Size> sizes) {
        super();
        this.name = name;
        this.style = style;
        this.codeColor = codeColor;
        this.colorSlug = colorSlug;
        this.color = color;
        this.onSale = onSale;
        this.regularPrice = regularPrice;
        this.actualPrice = actualPrice;
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
        return codeColor;
    }

    public void setCodeColor(String codeColor) {
        this.codeColor = codeColor;
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
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
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

}