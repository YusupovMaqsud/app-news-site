package uz.pdp.appnewssite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.entity.Lavozim;
import uz.pdp.appnewssite.payload.ApiResponse;
import uz.pdp.appnewssite.payload.LavozimDto;
import uz.pdp.appnewssite.repository.LavozimRepository;

import java.util.Optional;

@Service
public class LavozimService {
    @Autowired
    LavozimRepository lavozimRepository;

    public ApiResponse addLavozim(LavozimDto lavozimDto) {
        if (!lavozimRepository.existsByName(lavozimDto.getName())) {
            return new ApiResponse("Bunday lavozim bor", false);
        }

        Lavozim lavozim = new Lavozim(
                lavozimDto.getName(),
                lavozimDto.getHuquqList(),
                lavozimDto.getDescription()
        );
        lavozimRepository.save(lavozim);
        return new ApiResponse("Lavozim saqlandi", true);
    }



    public ApiResponse editLavozim(Long id, LavozimDto lavozimDto) {
        Optional<Lavozim> optionalLavozim = lavozimRepository.findById(id);
        if (!optionalLavozim.isPresent()) {
            return new ApiResponse("Bunday lavozim mavjud emas", false);
        }

        Lavozim lavozim = optionalLavozim.get();
        lavozim.setName(lavozimDto.getName());
        lavozim.setDescription(lavozimDto.getDescription());
        lavozim.setHuquqList(lavozimDto.getHuquqList());
        lavozimRepository.save(lavozim);
        return new ApiResponse("Role tahrirlandi", true);
    }



    public ApiResponse deleteById(Long id) {
        lavozimRepository.deleteById(id);
        return new ApiResponse("Role deleted", true);
    }
}
