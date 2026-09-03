package com.gwanghwan.portfolio.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
        @NotBlank(message = "이름을 입력해주세요.")
        @Size(max = 80, message = "이름은 80자 이내로 입력해주세요.")
        String name,

        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "올바른 이메일 형식을 입력해주세요.")
        @Size(max = 160, message = "이메일은 160자 이내로 입력해주세요.")
        String email,

        @NotBlank(message = "메시지를 입력해주세요.")
        @Size(min = 10, max = 2000, message = "메시지는 10자 이상 2000자 이내로 입력해주세요.")
        String message) {
}
