
package com.verisence.restaurants.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YelpBusinessesSearchResponse {

    @SerializedName("businesses")
    @Expose
    private List<Business> businesses = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public YelpBusinessesSearchResponse() {
    }

    /**
     * 
     * @param businesses
     */
    public YelpBusinessesSearchResponse(List<Business> businesses) {
        super();
        this.businesses = businesses;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

}
