package uz.pdp.appnewssite.aop;

import org.springframework.security.core.Transient;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HuquqniTekshirish {
    String huquq();
}
