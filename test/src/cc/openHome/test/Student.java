package cc.openHome.test;

import java.util.Date;

/**
 * Created by 28029 on 2017/9/18.
 */
public class Student {
    private String id;
    private String name;
    private String sex;
    private int age;
    private String grade;
    private String height;
    private String heavy;
    private Date birth;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(String id, String name, String sex, int age, String grade,
                   String height, String heavy, Date birth) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
        this.height = height;
        this.heavy = heavy;
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeavy() {
        return heavy;
    }

    public void setHeavy(String heavy) {
        this.heavy = heavy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", sex=" + sex
                + ", age=" + age + ", grade=" + grade + ", height=" + height
                + ", heavy=" + heavy + ", birth=" + birth + "]";
    }
}
