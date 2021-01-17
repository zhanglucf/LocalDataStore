package com.freemark;

public class Person {
    private String name;
    private String age;
    private String job;
    private String salary;

    public Person() {
    }

    public Person(String name, String age, String job, String salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
