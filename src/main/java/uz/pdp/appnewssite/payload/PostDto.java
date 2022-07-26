package uz.pdp.appnewssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @NotBlank(message = " Text bo'sh bo'lmasligi kerak")
    private String text;

    @NotBlank(message = "Title bo'sh bo'lmasligi kerak")
    private String title;

    @NotBlank(message = "Url bo'sh bo'lmasligi kerak")
    private String url;
}
