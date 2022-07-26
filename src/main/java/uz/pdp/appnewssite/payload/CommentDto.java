package uz.pdp.appnewssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    @NotBlank(message = " Text bo'sh bo'lmasligi kerak")
    private String text;

    @NotBlank(message = "Postid  bo'sh bo'lmasligi kerak")
    private Long postId;
}
