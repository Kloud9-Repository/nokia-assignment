package com.nokia.image.store.api.repository;

import com.nokia.image.store.api.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Photo, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("update Photo photo set photo.status =:status where photo.id in :ids")
    void markImagesAsDeleted(@Param("status") int status, @Param("ids") List<Integer> ids);
}
