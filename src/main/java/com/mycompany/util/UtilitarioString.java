/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;


/**
 *
 * @author mayco
 */
public class UtilitarioString {
    private static UtilitarioString instance;
    

    public static UtilitarioString getInstance() {
        return instance;
    }
    
    public String substitui(String texto, String simbolo){
        String str = texto;
        String strSimbolo = "";
        int size = str.length();
        int i;
        for (i=0; i<size;i++){
            strSimbolo += simbolo;
        }      
        strSimbolo.replace(str, strSimbolo);
        return strSimbolo;
    }
}
