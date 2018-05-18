package com.api.utils.files;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by logan on 16/7/22.
 */
public class FileUpload {
    public static final String FILE_PATH = "/download/";
    public static final String VIDEO_FILE_PATH = "/video/";
    public static final String FILE_TMP_PATH = "/excel/";

    //文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = UUID.randomUUID().toString()+"-"+file.getOriginalFilename();
        File tempFile = new File(request.getRealPath("WEB-INF")+FILE_PATH, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return FILE_PATH+tempFile.getName();
    }

    public static String uploadVideoFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = UUID.randomUUID().toString()+"-"+file.getOriginalFilename();
        File tempFile = new File(request.getRealPath("WEB-INF")+VIDEO_FILE_PATH, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return VIDEO_FILE_PATH+tempFile.getName();
    }

    public static File uploadFileToFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = UUID.randomUUID().toString()+"-"+file.getOriginalFilename();
        File tempFile = new File(request.getRealPath("WEB-INF")+FILE_TMP_PATH, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return tempFile;
    }

    public static File getFile(String fileName) {
        return new File(fileName);
    }
}
