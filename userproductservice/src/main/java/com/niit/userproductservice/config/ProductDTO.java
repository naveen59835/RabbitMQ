/*
 * Author : Naveen Kumar
 * Date : 18-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.config;

import org.json.simple.JSONObject;

public class ProductDTO {
    private JSONObject jsonObject;

    public ProductDTO(){

    }


    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
