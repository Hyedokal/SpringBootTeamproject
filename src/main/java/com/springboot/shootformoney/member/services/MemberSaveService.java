package com.springboot.shootformoney.member.services;

import com.springboot.shootformoney.member.dto.SignUpForm;
import com.springboot.shootformoney.member.entity.Member;
import com.springboot.shootformoney.member.enum_.Grade;
import com.springboot.shootformoney.member.enum_.Role;
import com.springboot.shootformoney.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;

@Service
@RequiredArgsConstructor
public class MemberSaveService {

    private final MemberRepository memberRepository;

    /**
     * 저장 여부 확인
     */
    public Member save(SignUpForm signUpForm) throws InvalidPropertiesFormatException{
        if(signUpForm == null) {throw new InvalidPropertiesFormatException("signUpForm 객체 null");}

        String mId = signUpForm.getMId();
        String mPw = signUpForm.getMPassword();
        String mName = signUpForm.getMName();
        String mPhone = signUpForm.getMPhone();
        String mEmail = signUpForm.getMEmail();
        String mNickName = signUpForm.getMNickName();

        Member member = Member.builder()
                .mId(mId)
                .mPassword(mPw)
                .mName(mName)
                .mPhone(mPhone)
                .mEmail(mEmail)
                .mNickName(mNickName)
                .role(Role.MEMBER)
                .grade(Grade.CONFERENCE)
                .mLevel(1)
                .build();

        return memberRepository.saveAndFlush(member);
    }
}
