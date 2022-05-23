package com.itis.dto;

import com.itis.models.FileInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FileInfoDto {
    private Long id;
    private String originalName;

    public static FileInfoDto from(FileInfo fileInfo){
        return FileInfoDto.builder()
                .id(fileInfo.getId())
                .originalName(fileInfo.getOriginalName())
                .build();

    }

    public static List<FileInfoDto> from(List<FileInfo> fileInfoList){
        return fileInfoList.stream().map(FileInfoDto::from).collect(Collectors.toList());
    }
}
