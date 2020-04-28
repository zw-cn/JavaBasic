package com.zw.spring.pojo;

import java.util.*;

/**
 * <p>Title: JavaBasic-com.zw.spring.pojo</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public class People {
    private int id;
    private int age;
    private String name;
    private String[] friends;
    private List<String> parents;
    private Set<String> cars;
    private Map<String,String> favs;
    private Properties prop;
    private Clothes clothes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public Set<String> getCars() {
        return cars;
    }

    public void setCars(Set<String> cars) {
        this.cars = cars;
    }

    public Map<String, String> getFavs() {
        return favs;
    }

    public void setFavs(Map<String, String> favs) {
        this.favs = favs;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", friends=" + Arrays.toString(friends) +
                ", parents=" + parents +
                ", cars=" + cars +
                ", favs=" + favs +
                ", prop=" + prop +
                ", clothes=" + clothes +
                '}';
    }
}
