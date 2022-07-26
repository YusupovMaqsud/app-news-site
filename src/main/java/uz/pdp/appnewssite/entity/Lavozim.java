package uz.pdp.appnewssite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import uz.pdp.appnewssite.entity.enums.Huquq;
import uz.pdp.appnewssite.entity.template.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lavozim extends AbstractEntity {

    @Column(nullable = false,unique = true)//bo'sh bo'lmasligi kerak,ADMIN,USER takrorlanmasligi k-k
    private String name; //ADMIN,USER VA BOSHQALAR

    @Enumerated(value = EnumType.STRING)
    @ElementCollection //
    private List<Huquq> huquqList;

    @Column(length = 600)
    private String description; //izoh

}
