package com.sailyang;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/19 20:01
 */
public enum Size {
    //小号
    SMALL("S","小号"),
    //中号
    MEDIUM("M","中号"),
    //大号
    LARGE("L","大号");

    private String abbr;

    private String title;

    private Size(String abbr, String title) {
        this.abbr = abbr;
        this.title = title;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getTitle() {
        return title;
    }

    public static Size fromAbbr(String abbr) {
        for(Size size : Size.values()) {
            if(size.getAbbr().equals(abbr)){
                return size;
            }
        }
        return null;
    }
}
