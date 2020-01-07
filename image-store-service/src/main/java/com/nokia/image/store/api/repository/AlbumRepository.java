package com.nokia.image.store.api.repository;

import com.nokia.image.store.api.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("update Album album set album.status =:status where album.id =:albumId")
    void markAlbumStatusAsDeleted(@Param("status") int status, @Param("albumId") int albumId);
}
