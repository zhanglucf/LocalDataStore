package com.freemark;

public class Spart {

    private String seq;
    private String name;
    private CaiLiaoFei caiLiaoFei;
    private ZhuanYongFei zhuanYongFei;

    public Spart() {
    }

    public Spart(String seq, String name, CaiLiaoFei caiLiaoFei, ZhuanYongFei zhuanYongFei) {
        this.seq = seq;
        this.name = name;
        this.caiLiaoFei = caiLiaoFei;
        this.zhuanYongFei = zhuanYongFei;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CaiLiaoFei getCaiLiaoFei() {
        return caiLiaoFei;
    }

    public void setCaiLiaoFei(CaiLiaoFei caiLiaoFei) {
        this.caiLiaoFei = caiLiaoFei;
    }

    public ZhuanYongFei getZhuanYongFei() {
        return zhuanYongFei;
    }

    public void setZhuanYongFei(ZhuanYongFei zhuanYongFei) {
        this.zhuanYongFei = zhuanYongFei;
    }
}
