/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;

/**
 *
 * @author wrtrg2
 */
public class ImageList {

    int id;
    String base64str;

    public ImageList(int id, String base64str) {
        this.id = id;
        this.base64str = base64str;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBase64str() {
        return base64str;
    }

    public void setBase64str(String base64str) {
        this.base64str = base64str;
    }

    public ImageList(){
    
    }
}
