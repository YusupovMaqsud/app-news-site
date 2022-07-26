package uz.pdp.appnewssite.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    private final String resourceName;  //lavozim//  qaysi tabledan topolmadik

    private final String resourceField; //name //qaysi fieldi bo'yicha qidiruvdik

    private final Object object;//USER,ADMIN,IDNI QIDIRDIM


}
