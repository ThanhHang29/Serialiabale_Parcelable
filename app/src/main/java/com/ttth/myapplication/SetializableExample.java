package com.ttth.myapplication;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Hang on 12/14/2016.
 */

public class SetializableExample implements Serializable{
    private String name;
    private int year;
    private List<Skill> arrSkills;
    public static  class Skill implements  Serializable{
        private String name;
        boolean program;
    }
}
