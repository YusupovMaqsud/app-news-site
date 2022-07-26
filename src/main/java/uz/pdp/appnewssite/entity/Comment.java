package uz.pdp.appnewssite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appnewssite.entity.template.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends AbstractEntity {

    @Column(nullable = false,columnDefinition = "text")
    private String text; //text

    @ManyToOne(fetch = FetchType.LAZY) //Comment qaysi maqolaga(Post)ga tegishli ekanligi
    private Post post;

    //Bu erda Commentni kim yozganligini quymaymiz chunki AbctractEntityda
    // private User createdBy kim yozganligi bor
}
