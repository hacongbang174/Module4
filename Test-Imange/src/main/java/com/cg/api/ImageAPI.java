package com.cg.api;


import com.cg.model.ImageEntity;
import com.cg.repository.ImageRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/upload")
public class ImageAPI {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private Cloudinary cloudinary;

    @PostMapping
    public String uploadImage(@RequestBody ImageEntity imageEntity, Model model) {
        try {
            // Lưu ảnh lên Cloudinary
            Map uploadResult = cloudinary.uploader().upload(imageEntity.getImageUrl().getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("secure_url");

            // Lưu thông tin ảnh vào cơ sở dữ liệu
            ImageEntity imageEntityNew = new ImageEntity();
            imageEntity.setImageUrl(imageUrl);
            imageRepository.save(imageEntityNew);

            // Trả về URL của ảnh để hiển thị trong JavaScript
            model.addAttribute("imageUrl", imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/upload";
    }
}
