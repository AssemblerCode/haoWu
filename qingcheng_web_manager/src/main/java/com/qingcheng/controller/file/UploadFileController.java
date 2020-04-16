package com.qingcheng.controller.file;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyun.oss.OSSClient;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadFileController {
    @Reference
    private BrandService brandService;

    @Autowired
    private OSSClient client;

    @Value("${bucketName}")
    private String bucketName;

    @Value("${brand}")
    private String brand;

    @PostMapping("/native")
    public String nativeUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {//参数名称叫file
        System.out.println("native......");
        String path = request.getSession().getServletContext().getRealPath("img");
        String filePath = path + "/" + file.getOriginalFilename();
        File desFile = new File(filePath);
        if (!desFile.getParentFile().exists()) {
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:9101/img/" + file.getOriginalFilename();

    }

    @PostMapping("/oss")
    public String ossUpload(@RequestParam("file") MultipartFile file) {
        String result = "";
        try {
            String fileName = brand + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            System.out.println("bucketName = " + bucketName);
            client.putObject(bucketName, fileName, file.getInputStream());
            result = "https://" + bucketName + ".oss-cn-hangzhou.aliyuncs.com/" + fileName;
//            client.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

}
