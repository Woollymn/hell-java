package spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public MemberRegisterService() {}

    public void regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());

        if(member != null) {
            throw new AlreadyExistingMemberException("dup email " + req.getEmail());
        }
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(),
                new Date());

        memberDao.insert(newMember);
    }
}
