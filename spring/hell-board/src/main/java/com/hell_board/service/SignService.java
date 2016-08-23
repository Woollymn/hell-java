package com.hell_board.service;

import com.hell_board.exception.AlreadyExistingMemberException;
import com.hell_board.exception.IdPasswordNoMatchingException;
import com.hell_board.exception.MemberNotFoundException;
import com.hell_board.dao.MemberDao;
import com.hell_board.domain.Member;
import com.hell_board.data.request.SignInRequest;
import com.hell_board.data.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Objects.isNull;

public class SignService {

    @Autowired
    private MemberDao memberDao;

    public int signUp(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();
        String confirmedPassword = signUpRequest.getConfirmedPassword();
        Member member = memberDao.findByEmail(email);

        if (!isNull(member)) {
            throw new AlreadyExistingMemberException("이미 등록된 사용자입니다 : " + email);
        }

        if (password.equals(confirmedPassword)) {
            Member newMember = new Member(
                    signUpRequest.getEmail(),
                    signUpRequest.getPassword(),
                    signUpRequest.getName(),
                    signUpRequest.getRegisterDateTime()
                    );

            return memberDao.insert(newMember);
        } else {
            throw new IdPasswordNoMatchingException("암호를 다시 확인해주세요.");
        }

    }

    public Member signIn(SignInRequest signInRequest) {
        Member member = memberDao.findByEmail(signInRequest.getEmail());
        String confirmedPassword;

        if (!isNull(member)) {
            confirmedPassword = member.getPassword();
        } else {
            throw new MemberNotFoundException();
        }

        if (signInRequest.getPassword().equals(confirmedPassword)) {
            return member;
        } else {
            throw new IdPasswordNoMatchingException("암호를 다시 확인해주세요.");
        }
    }

    public void signOut() {
        // TODO - 로그아웃한 날짜를 저장
    }
}