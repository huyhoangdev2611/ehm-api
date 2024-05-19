package com.ehm.ehmapi.controller;

import com.ehm.ehmapi.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/files"})
class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping
    public List<String> presignFiles(@RequestParam("key") List<String> filePaths) {
        return fileService.presign(filePaths);
    }

    @PostMapping
    public List<String> presignFilesPost(@RequestBody List<String> filePaths) {
        return fileService.presign(filePaths);
    }

}