package ra.demo.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CandidateCreateDTO {
    @NotBlank( message = "ho ten khong duoc de trong")
    @Size(min = 5, max = 50, message = "ho ten phai tren 5 va nho hon 50 ky tu")
    private String fullName;

    @NotBlank( message = "email khong duoc de trong")
    @Email( message = "email khong dung dinh dang")
    private String email;

    @NotNull( message = "tuoi khong duoc de trong")
    @Min(value = 18, message = "tuoi phai tren 18")
    private Integer age;

    @NotNull( message = "kinh nghiem khong duoc de trong")
    @Min(value = 0, message = "kinh nghiem khong dc am")
    private Integer yearsOfExperience;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(
            regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "Số điện thoại không hợp lệ"
    )
    private String phone;
}
