package com.example.demo_01.Controller;
import com.example.demo_01.DTO.UserDto;
import com.example.demo_01.repository.UserRepository;
import com.example.demo_01.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /* 회원 가입 폼으로 이동 */
    @GetMapping("/auth/join")
    public String join() {
        return "userJoin";
    }

    @PostMapping("/auth/joinProc")
    public String joinProc(@Valid UserDto.RequestUserDto userDto, BindingResult bindingResult, Model model) {

        /* 검증 */
        if(bindingResult.hasErrors()) {
            /* 회원가입 실패 시 입력 데이터 값 유지 */
            model.addAttribute("userDto", userDto);

            /* 유효성 검사를 통과하지 못 한 필드와 메시지 핸들링 */
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
                //log.info("회원가입 실패 ! error message : "+error.getDefaultMessage());
            }

            /* Model에 담아 view resolve */
            for(String key : errorMap.keySet()) {
                model.addAttribute(key, errorMap.get(key));
            }

            /* 회원가입 페이지로 리턴 */
            return "userJoin";
        }

        // 회원가입 성공 시
        userService.userJoin(userDto);
        //log.info("회원가입 성공");
        return "redirect:/board/list";
    }
}
