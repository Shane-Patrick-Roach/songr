package com.shaneroach.songr.repository;

import com.shaneroach.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongrRepository extends JpaRepository<Album, Long>
{

}