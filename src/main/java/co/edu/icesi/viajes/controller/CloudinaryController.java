package co.edu.icesi.viajes.controller;

import co.edu.icesi.viajes.domain.ImagenDestino;
import co.edu.icesi.viajes.service.CloudinaryService;
import co.edu.icesi.viajes.service.ImagenDestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
//@CrossOrigin(origins = "http://localhost:4200")
public class CloudinaryController {
    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenDestinoService imagenDestinoService;

    @GetMapping("/list")
    public ResponseEntity<List<ImagenDestino>> list(){
        List<ImagenDestino> list = imagenDestinoService.findByOrderByImageId();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> upload(@RequestParam MultipartFile multipartFile, @RequestParam Integer planId) throws Exception {
        System.out.println("ESTA EN LA API DE CLOUDINARY");
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity<>("Imagen no valida", HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        ImagenDestino image = new ImagenDestino((String) result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"));
        image.setIdPlan(planId);
        imagenDestinoService.save(image);
        return new ResponseEntity<>("Se subio exitosamente la imagen", HttpStatus.OK);
    }

    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Image> imageOptional = imageService.getOne(id);
        if (imageOptional.isEmpty()) {
            return new ResponseEntity<>("n'existe pas", HttpStatus.NOT_FOUND);
        }
        Image image = imageOptional.get();
        String cloudinaryImageId = image.getImageId();
        try {
            cloudinaryService.delete(cloudinaryImageId);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to delete image from Cloudinary", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        imageService.delete(id);
        return new ResponseEntity<>("image supprimée !", HttpStatus.OK);
    }
     */

}