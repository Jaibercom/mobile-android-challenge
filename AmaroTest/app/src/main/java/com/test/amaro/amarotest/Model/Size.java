package com.test.amaro.amarotest.Model;

/**
 * Created by jaiber on 1/19/18.
 */

public class Size {

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

}
