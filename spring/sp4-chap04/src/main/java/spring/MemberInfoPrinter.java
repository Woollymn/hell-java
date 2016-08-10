package spring;

import javax.annotation.Resource;

public class MemberInfoPrinter {

    @Resource(name="memberDao")
    private MemberDao memberDao;
    private MemberPrinter printer;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Resource(name="memberPrinter")
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if(member == null) {
            System.out.printf("데이터 없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }
}
