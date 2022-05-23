package com.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "file_info")
public class FileInfo {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "original_name")
    private String originalName; //originalFileName
    @Column(name = "storage_name")
    private String storageName; //storageFileName
    @Column(name = "file_size")
    private Long fileSize;//size
    @Column(name = "file_type")
    private String fileType;//type
    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client owner;

    @OneToOne(mappedBy = "profilePicture")
    private Client avatarUser;

    public static FileInfo fromMultipart(MultipartFile file){
        return FileInfo.builder()
                .originalName(file.getOriginalFilename())
                .fileSize(file.getSize())
                .fileType(file.getContentType())
                .build();
    }
    public static List<FileInfo> fromMultipart(MultipartFile[] files){
        return Arrays.stream(files).map(FileInfo::fromMultipart).collect(Collectors.toList());
    }
}
