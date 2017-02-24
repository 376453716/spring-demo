package com.xh.demo;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Xiong Hao
 */
public class UserApplicationTest {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int i = 0;
        try {
            int b = 1 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.println(111);
            return 3;
        }
    }
}
