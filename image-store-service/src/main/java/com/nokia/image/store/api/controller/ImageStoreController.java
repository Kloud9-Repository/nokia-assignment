package com.nokia.image.store.api.controller;

import com.nokia.image.store.api.entity.Album;
import com.nokia.image.store.api.entity.Photo;
import com.nokia.image.store.api.service.ImageStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("image-store-service")
public class ImageStoreController {
    @Autowired
    private ImageStoreService imageStoreService;

    @PostMapping("/createAlbum")
    public Album createAlbum(@RequestBody Album album) {
        return imageStoreService.createAlbum(album);
    }

    @PostMapping("/add-images")
    public String saveImages(@RequestBody List<Photo> photos) {
        return imageStoreService.saveImages(photos);
    }

    @DeleteMapping("/remove-album/{albumId}")
    public String removeAlbum(@PathVariable int albumId) {
        return imageStoreService.deleteAlbum(albumId);
    }

    @PostMapping("/remove-images")
    public String removeImages(@RequestBody List<Integer> ids) {
        return imageStoreService.deleteImages(ids);
    }
}
