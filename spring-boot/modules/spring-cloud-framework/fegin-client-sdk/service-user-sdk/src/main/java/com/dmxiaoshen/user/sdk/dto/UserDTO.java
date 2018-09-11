package com.dmxiaoshen.user.sdk.dto;

/**
 * Created by hzhsg on 2018/8/21.
 */
public class UserDTO {

    private String id;
    private String name;
    private String cellphone;
    private Integer age;

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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", age=" + age +
                '}';
    }
}
