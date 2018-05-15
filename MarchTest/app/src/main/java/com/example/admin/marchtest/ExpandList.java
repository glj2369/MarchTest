package com.example.admin.marchtest;

public class ExpandList {
    private String tv1;
    private String tv2;
    private int pic;

    public ExpandList(String tv1, String tv2, int pic) {
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.pic = pic;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
