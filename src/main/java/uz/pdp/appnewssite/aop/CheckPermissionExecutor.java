package uz.pdp.appnewssite.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.exceptions.ForbiddenException;

@Component
@Aspect
public class CheckPermissionExecutor {

    @Before(value = "@annotation(huquqniTekshirish)")
    public void checkUserPermissionMyMethod(HuquqniTekshirish huquqniTekshirish){
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        GrantedAuthority authority = user.getAuthorities()
                .stream()
                .filter(grantedAuthority -> grantedAuthority.getAuthority().equals(huquqniTekshirish.huquq()))
                .findFirst().orElse(null);

        if (authority == null) {
            throw new ForbiddenException(huquqniTekshirish.huquq(),"Ruxsat yo'q");
        }

//        boolean exist=false;
//        for (GrantedAuthority authority : user.getAuthorities()) {
//           if(authority.getAuthority().equals(huquqniTekshirish.huquq())){
//               exist=true;
//               break;
//           }
//        }
//        if(!exist){
//        throw new ForbiddenExeption(huquqniTekshirish.huquq(),"Ruxsat yo'q");
//        }
    }
}
