package com.itis.controllers;

import com.itis.models.Client;
import com.itis.service.FilesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller()
@RequestMapping(value = "/files")
@AllArgsConstructor
public class FilesController {
    private final FilesService filesService;
    @PostMapping(value = "/upload")
    public String uploadMultipleFiles(MultipartFile[] files, HttpSession session){
        filesService.saveFiles((Client) session.getAttribute("client"), files);
        return "redirect:/files/view";
    }

    @GetMapping(value = "/download/{id}")
    public void downloadFile(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        filesService.downloadFile(id, response.getOutputStream());
        response.flushBuffer();
    }

    @GetMapping("/view")
    public String viewAllFiles(Model model, HttpSession session){
        model.addAttribute("files",filesService.getFileList((Client) session.getAttribute("client")));
        return "view-files";
    }
}
