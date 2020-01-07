package com.nokia.image.store.api.domain;

import com.nokia.image.store.api.entity.Album;
import com.nokia.image.store.api.entity.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageStoreRequest {
    private Album album;
    private List<Photo> photos;
}
