package uz.pdp.appnewssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appnewssite.Service.AuthService;
import uz.pdp.appnewssite.Service.LavozimService;
import uz.pdp.appnewssite.aop.HuquqniTekshirish;
import uz.pdp.appnewssite.payload.ApiResponse;
import uz.pdp.appnewssite.payload.LavozimDto;
import uz.pdp.appnewssite.payload.RegisterDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lavozim")
public class LavozimController {
    @Autowired
    LavozimService lavozimService;

    @PreAuthorize(value = "hasAuthority('ADD_LAVOZIM')")
    @PostMapping
    public HttpEntity<?> addLavozim(@Valid @RequestBody LavozimDto lavozimDto){
        ApiResponse apiResponse=lavozimService.addLavozim(lavozimDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }



   // @PreAuthorize(value = "hasAuthority('EDIT_LAVOZIM')")
    @HuquqniTekshirish(huquq = "EDIT_LAVOZIM")
    @PutMapping
    public HttpEntity<?> editLavozim(@PathVariable Long id ,@Valid @RequestBody LavozimDto lavozimDto){
        ApiResponse apiResponse=lavozimService.editLavozim(id,lavozimDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }



    @PreAuthorize(value = "hasAuthority('DELETE_ROLE')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteLavozim(@PathVariable Long id) {
        ApiResponse apiResponse = lavozimService.deleteById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 204 : 409).body(apiResponse);
    }

}
