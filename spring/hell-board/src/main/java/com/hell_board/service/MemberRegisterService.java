package com.hell_board.service;

import com.hell_board.dao.MemberDao;
import com.hell_board.dto.RegisterDto;
import com.hell_board.entity.Member;
import com.hell_board.exception.AlreadyExistingMemberException;

import java.util.Date;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void regist(RegisterDto registerDto) {
        Member member = memberDao.selectByEmail(registerDto.getEmail());

        if (member != null) {
            throw new AlreadyExistingMemberException("dup email " + registerDto.getEmail());
        }

        Member newMember = new Member(registerDto.getEmail(), registerDto.getPassword(), registerDto.getName(), new Date());
        memberDao.insert(newMember);
    }
}
