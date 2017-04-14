package test3.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "adao")
public class ADao {

    public void GetA1() {
        System.out.println("I am getA1");
    }

    public void GetA2() {
        System.out.println("I am getA2");
    }
    public void getA3() {
        System.out.println("I am getA3");
    }
    public void setAAA() {
        System.out.println("I am setAAA");
    }
    public void listAAA() {
        System.out.println("I am listAAA");
    }

}
