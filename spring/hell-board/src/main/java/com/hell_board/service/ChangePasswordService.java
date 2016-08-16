package com.hell_board.service;

import com.hell_board.dao.MemberDao;
import com.hell_board.entity.Member;
import com.hell_board.exception.MemberNotFoundException;

public class ChangePasswordService {
    private MemberDao memberDao;

    public ChangePasswordService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void changePassword(String email, String oldPassword, String newPassword) {
        Member member = memberDao.selectByEmail(email);

        if (member == null) {
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPassword, newPassword);

        memberDao.update(member);
    }
}
