package com.freemark;

public class Student {
    private String name;
    private String classes;
    private Integer chinese;
    private Integer math;
    private Integer english;
    private Integer physical;
    public Student() {}

    public Student(String name, String classes, Integer chinese, Integer math, Integer english, Integer physical) {
        this.name = name;
        this.classes = classes;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.physical = physical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getPhysical() {
        return physical;
    }

    public void setPhysical(Integer physical) {
        this.physical = physical;
    }
}
