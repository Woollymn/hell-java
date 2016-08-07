package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 스프링의 bean 객체들은 싱글톤 범위를 갖는다.
 */
public class Main2 {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:applicationContext.xml");

        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println("(g1 == g2) = " + (g1 == g2));
        ctx.close();
    }
}
