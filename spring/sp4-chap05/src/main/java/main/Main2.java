package main;

import config.JavaConfig2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main2 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);

        RegisterRequest regReq = new RegisterRequest();
        regReq.setEmail("hkkang@woowahan.com");
        regReq.setName("강현구");
        regReq.setPassword("1234");
        regReq.setConfirmPassword("1234");
        regSvc.regist(regReq);

        infoPrinter.printMemberInfo("hkkang@woowahan.com");
    }
}
