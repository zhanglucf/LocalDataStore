package com.freemark;

import com.google.gson.Gson;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordUtil {
    private static final String TEMPLATE_FOLDER = "E:\\myProjects\\netty\\src\\main\\resources\\template\\";
    private static final String DOC_FOLDER = "E:\\myProjects\\netty\\src\\main\\resources\\doc";
    private static final String CHARSET = "UTF-8";
    private static final String FREEMARKER_VERSION ="2.3.28";

    public static void generateWord(Map<String, Object> dataMap,String ftlName, String docName) throws Exception {
        // 设置FreeMarker的版本和编码格式
        Configuration configuration = new Configuration(new Version(FREEMARKER_VERSION));
        configuration.setDefaultEncoding(CHARSET);
        // 设置FreeMarker生成Word文档所需要的模板的路径
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_FOLDER));
        // 设置FreeMarker生成Word文档所需要的模板
        Template t = configuration.getTemplate(ftlName, CHARSET);
        // 创建一个Word文档的输出流
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(DOC_FOLDER,docName)), CHARSET));
        //FreeMarker使用Word模板和数据生成Word文档
        t.process(dataMap, out);
        out.flush();
        out.close();
    }

    private static Map<String, Object> getWordData() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("var1", "一个牛逼的项目");
        dataMap.put("var2", "没有依据");
        dataMap.put("var3", "贝吉塔行星");
        dataMap.put("var4", "Z战士");
        dataMap.put("var5", "多级审核");
        dataMap.put("var6", "2021-01-15~2021-01-16");
        dataMap.put("var7", "会议概括会议概括会议概括会议概括会议概括会议概括会议概括会议概括会议概括会议概括会议概括会议概括会议概括会议概括");
        dataMap.put("var8", "项目基本情况项目基本情况项目基本情况项目基本情况项目基本情况项目基本情况项目基本情况项目基本情况项目基本情况");
        dataMap.put("var9", "项目送审情况项目送审情况项目送审情况项目送审情况项目送审情况项目送审情况项目送审情况项目送审情况项目送审情况");
        String json = "{\"topic\":\"一、汽车研制概算\",\"content\":\"\",\"subList\":[{\"topic\":\"1、底盘\",\"content\":\"送审100万元，核审60万元，核减40万元\",\"subList\":[{\"topic\":\"1、轮毂\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]},{\"topic\":\"2、方向盘\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]}]},{\"topic\":\"2、发动机\",\"content\":\"送审100万元，核审60万元，核减40万元\",\"subList\":[{\"topic\":\"1、进气阀\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]}]}]}";
        String json2 = "{\"topic\":\"二、坦克研制概算\",\"content\":\"\",\"subList\":[{\"topic\":\"1、火力输出装置\",\"content\":\"送审100万元，核审60万元，核减40万元\",\"subList\":[{\"topic\":\"1、360旋转炮台\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]},{\"topic\":\"2、超远程火箭炮\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]}]},{\"topic\":\"2、防御装置\",\"content\":\"送审100万元，核审60万元，核减40万元\",\"subList\":[{\"topic\":\"1、护板\",\"content\":\"具体情况如下：\",\"subContents\":[{\"content\":\"①材料费\",\"content2\":\"送审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"②专用费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"},{\"content\":\"③燃油费\",\"content2\":\"审3万元，审核2万元，核减1万元\",\"content3\":\"主要核审理由：额度有点超出市场均价\"}]}]}]}";
        final Gson gson = new Gson();
        final Article article = gson.fromJson(json, Article.class);
        final Article article2 = gson.fromJson(json2, Article.class);
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        articles.add(article2);
        dataMap.put("articles",articles);
        return dataMap;
    }

    private static Map<String, Object> getWordData2() {
        Map<String, Object> dataMap = new HashMap<>();
        final List<Student> students = new ArrayList<>();
        students.add(new Student("风清扬","一班",99,98,100,98));
        students.add(new Student("林青霞","一班",99,98,100,98));
        students.add(new Student("张三丰","一班",99,98,100,98));
        dataMap.put("students",students);
        return dataMap;
    }

    private static Map<String, Object> getWordData3() {
        Map<String, Object> dataMap = new HashMap<>();
//        final List<Person> persons = new ArrayList<>();
//        persons.add(new Person("风清扬","16","程序员","1.5W"));
        dataMap.put("person",new Person("风清扬","16",null,"1.5W"));
        return dataMap;
    }

    private static Map<String, Object> getWordData4() {
        Map<String, Object> dataMap = new HashMap<>();
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("风清扬","16","程序员","1.5W"));
        persons.add(new Person("风清扬","16","程序员","1.5W"));
        persons.add(new Person("风清扬","16","程序员","1.5W"));
        persons.add(new Person("风清扬","16","程序员","1.5W"));
        dataMap.put("persons",persons);
        return dataMap;
    }

    public static void main(String[] args) throws Exception {
        WordUtil.generateWord(getWordData(),"tem.ftl","专家组评审.doc");
//        WordUtil.generateWord(getWordData2(),"table.ftl","动态创建表格.doc");
//        WordUtil.generateWord(getWordData3(),"if.ftl","if.doc");
//        WordUtil.generateWord(getWordData4(),"if_list.ftl","if_list.doc");
    }
}

