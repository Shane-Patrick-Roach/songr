package com.shaneroach.songr.repository;

import com.shaneroach.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Album, Long>
{
    Album findByTitle(String title);
}