package com.itis.service;

import com.itis.dto.FileInfoDto;
import com.itis.models.Client;
import com.itis.models.FileInfo;
import com.itis.repositories.FileInfoRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Value("${files.storage.path}")
    private String path;

    @Override
    public void saveFiles(Client client, MultipartFile... files) {
        List<FileInfo> fileInfoList = new ArrayList<>();
        for(MultipartFile x : files){
            String d = x.getName();
            String s = x.getOriginalFilename();
            String storageName = UUID.randomUUID() + "." + FilenameUtils.getExtension(x.getOriginalFilename());
            try {
                Files.copy(x.getInputStream(), Path.of(path + "\\" + storageName));
                FileInfo fileInfo = FileInfo.fromMultipart(x);
                fileInfo.setStorageName(storageName);
                fileInfo.setOwner(client);
                fileInfoList.add(fileInfo);
                fileInfoRepository.save(fileInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void downloadFile(Long id, OutputStream outputStream) {
        File file = new File(path + "\\" +
                fileInfoRepository.getById(id).getStorageName());

        try {
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadFile(String uid, OutputStream outputStream) {
        File file = new File(path + "\\" + uid);

        try {
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FileInfoDto> getFileList(Client client) {
        return FileInfoDto.from(fileInfoRepository.getByOwner(client));
    }
}
