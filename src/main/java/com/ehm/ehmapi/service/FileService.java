package com.ehm.ehmapi.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class FileService {
    @Autowired
    private StorageService storageService;

    public List<String> presign(List<String> filePaths) {
        return filePaths.parallelStream().map(storageService::presign).collect(Collectors.toList());
    }

}