package com.tiny.model;

import java.io.Serializable;

public class Link implements Serializable{

    String code;

    public Link (String codeStr){
        this.code  = codeStr;
    }
}
