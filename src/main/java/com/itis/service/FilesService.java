package com.itis.service;

import com.itis.dto.FileInfoDto;
import com.itis.models.Client;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

public interface FilesService {
    void saveFiles(Client client, MultipartFile ... files);
    void downloadFile(Long id,OutputStream outputStream);
    void downloadFile(String uid,OutputStream outputStream);
    List<FileInfoDto> getFileList(Client client);
}
