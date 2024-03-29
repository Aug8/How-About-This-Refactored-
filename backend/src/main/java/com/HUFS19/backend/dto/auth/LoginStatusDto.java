package com.HUFS19.backend.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginStatusDto {
    @NonNull
    boolean status;
    String userId = "";
}
