package com.bluecar.bluecar.service;

import com.bluecar.bluecar.dto.BoardDTO;
import com.bluecar.bluecar.dto.CarDTO;
import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.dto.MemberDTO;
import com.bluecar.bluecar.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public List<MemberDTO> findAll() {
       return adminRepository.findAll();
    }

    public MemberDTO findId(MemberDTO memberDTO) {
        return adminRepository.findId(memberDTO);
    }

    public void userUpdate(MemberDTO memberDTO) {
         adminRepository.userUpdate(memberDTO);
    }


    public void stateUdpate(String state , Long id) {
        adminRepository.stateUpdate(state, id);
    }

    public void adminCommentSave(CommentDTO commentDTO) {
        adminRepository.adminCommentSave(commentDTO);
    }

    public void carSave(CarDTO carDTO) throws IOException {
       MultipartFile carFile= carDTO.getCarFile();
       String originalFilename= carFile.getOriginalFilename();
        String storedFileName = System.currentTimeMillis() + "_" + originalFilename;
        String savePath = "C:/springboot_img/" + storedFileName;
        carFile.transferTo(new File(savePath));


        adminRepository.carSave(carDTO,storedFileName);
    }

    public void carDelete(String id) {
        adminRepository.carDelete(id);
    }
}
