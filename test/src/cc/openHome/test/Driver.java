package cc.openHome.test;

import java.util.Date;

/**
 * Created by 28029 on 2017/9/18.
 */
public class Driver {
    private String id;
    private String sex;
    private int age;
    private String carHeavy;
    private String carLenghth;
    private String carId;
    private String name;
    private Date birth;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String getCarHeavy() {
        return carHeavy;
    }
    public void setCarHeavy(String carHeavy) {
        this.carHeavy = carHeavy;
    }
    public String getCarLenghth() {
        return carLenghth;
    }
    public void setCarLenghth(String carLenghth) {
        this.carLenghth = carLenghth;
    }
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    @Override
    public String toString() {
        return "Driver [id=" + id + ", sex=" + sex + ", age=" + age
                + ", carHeavy=" + carHeavy + ", carLenghth=" + carLenghth
                + ", carId=" + carId + ", name=" + name + ", birth=" + birth
                + "]";
    }



}
