package uz.pdp.appnewssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appnewssite.entity.enums.Huquq;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LavozimDto {
    @NotBlank       // to'liq bo'lsin @NotNull quysak probellarni utqazadi
    private String name;

    private String description;

    @NotEmpty
    private List<Huquq>huquqList;
}
