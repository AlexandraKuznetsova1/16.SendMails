package com.itis.repositories;

import com.itis.models.Client;
import com.itis.models.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    List<FileInfo> getByOwner(Client client);
    FileInfo getByStorageName(String uid);
    FileInfo getById(Long id);
}
