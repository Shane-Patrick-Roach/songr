package com.shaneroach.songr.repository;

import com.shaneroach.songr.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<Song, Long>
{
}