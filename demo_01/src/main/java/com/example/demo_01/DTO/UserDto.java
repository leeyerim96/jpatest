package com.example.demo_01.DTO;

import com.example.demo_01.entity.Board;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import com.example.demo_01.entity.User;
import javax.management.relation.Role;

@Data
public class UserDto {

    /* 회원 서비스 요청 RequestDTO 클래스 */
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    @Setter
    public static class RequestUserDto{
        private Integer user_idx;

        @NotBlank(message = "아이디는 필수 입력값입니다.")
        @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
        private String userId;

        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
        private String password;

        @NotBlank(message = "이름은 필수 입력값입니다.")
        @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$" , message = "이름은 특수문자를 포함하지 않은 2~10자리여야 합니다.")
        private String userNm;

        @NotBlank(message = "이메일은 필수 입력값입니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        private String email;
        private String salt;
        private Role role;

        /* 암호화된 password */
        public void encryptPassword(String BCryptpassword) {
            this.password = BCryptpassword;
        }

        /* DTO -> Entity */
        public User toEntity() {
            return User.builder()
                    .user_idx(user_idx)
                    .userId(userId)
                    .email(email)
                    .userNm(userNm)
                    .password(password)
                    .salt(salt)
                    .build();
        }
    }

}