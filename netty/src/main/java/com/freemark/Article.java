package com.freemark;

import com.google.gson.Gson;

import java.util.List;

public class Article {
    public String topic;
    public String content;
    public String content2;
    public String content3;
    public List<Article> subList;
    public List<SubContent> subContents;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public List<Article> getSubList() {
        return subList;
    }

    public void setSubList(List<Article> subList) {
        this.subList = subList;
    }

    public List<SubContent> getSubContents() {
        return subContents;
    }

    public void setSubContents(List<SubContent> subContents) {
        this.subContents = subContents;
    }

    public static void main(String[] args) {
//        String json = "{\"topic\":\"一级标题\",\"content\":\"一级正文\",\"subList\":[{\"topic\":\"二级标题\",\"content\":\"二级正文\",\"subList\":[{\"topic\":\"三级标题\",\"content\":\"三级正文\",\"subList\":[]},{\"topic\":\"三级标题\",\"content\":\"三级正文\",\"subList\":[]}]},{\"topic\":\"二级标题\",\"content\":\"二级正文\",\"subList\":[{\"topic\":\"三级标题\",\"content\":\"三级正文\",\"subList\":[]}]}]}";
        String json = "{\"topic\":\"牛逼系统研制概算\",\"content\":\"\",\"subList\":[{\"topic\":\"1、汽车\",\"content\":\"送审100万元，核审60万元，核减40万元\",\"subList\":[{\"topic\":\"①轮毂\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费送\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]},{\"topic\":\"②方向盘\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费送\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]}]},{\"topic\":\"2、飞机\",\"content\":\"送审100万元，核审60万元，核减40万元\",\"subList\":[{\"topic\":\"①起落架\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费送\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]}]}]}";
        final Gson gson = new Gson();
        final Article article = gson.fromJson(json, Article.class);
        System.out.println(article);
    }
}
