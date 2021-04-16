package com.zetatech.foodapp.utils;

/**
 * Created by besha on 11/9/2017.
 */

public class ValidationText {



    public static final String PASSWORD_PATTERN =  "[a-zA-Z0-9@._-][^|&=;<>\\s]{4,}$";


    public static  boolean valid(String text , String PATTERN)
    {
       return text.matches(PATTERN);
    }




}
