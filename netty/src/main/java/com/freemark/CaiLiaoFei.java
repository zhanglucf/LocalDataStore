package com.freemark;

public class CaiLiaoFei {
    public String songShenJia;
    public String heShenJia;
    public String heJian;
    public String shenHeLiYou;

    public CaiLiaoFei(String songShenJia, String heShenJia, String heJian,String shenHeLiYou) {
        this.songShenJia = songShenJia;
        this.heShenJia = heShenJia;
        this.heJian = heJian;
        this.shenHeLiYou = shenHeLiYou;
    }

    public String getSongShenJia() {
        return songShenJia;
    }

    public void setSongShenJia(String songShenJia) {
        this.songShenJia = songShenJia;
    }

    public String getHeShenJia() {
        return heShenJia;
    }

    public void setHeShenJia(String heShenJia) {
        this.heShenJia = heShenJia;
    }

    public String getHeJian() {
        return heJian;
    }

    public void setHeJian(String heJian) {
        this.heJian = heJian;
    }

    public String getShenHeLiYou() {
        return shenHeLiYou;
    }

    public void setShenHeLiYou(String shenHeLiYou) {
        this.shenHeLiYou = shenHeLiYou;
    }
}
