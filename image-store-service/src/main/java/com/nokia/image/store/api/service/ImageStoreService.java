package com.nokia.image.store.api.service;

import com.nokia.image.store.api.entity.Album;
import com.nokia.image.store.api.entity.Photo;
import com.nokia.image.store.api.repository.AlbumRepository;
import com.nokia.image.store.api.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageStoreService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private MessageChannel output;

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Transactional
    public String deleteAlbum(int albumId) {
        albumRepository.markAlbumStatusAsDeleted(0, albumId);
        return "album " + albumId + " deleted successfully !!";
    }

    public String saveImages(List<Photo> photos) {
        List<Photo> photoList = imageRepository.saveAll(photos);
        String response = photoList.size() + " images stored successfully !!";
        output.send(MessageBuilder.withPayload(response).build());
        return response;
    }

    @Transactional
    public String deleteImages(List<Integer> ids) {
        imageRepository.markImagesAsDeleted(0, ids);
        String response = "Images " + "[" + ids + "]" + " deleted successfully !!";
        output.send(MessageBuilder.withPayload(response).build());
        return response;
    }


}
