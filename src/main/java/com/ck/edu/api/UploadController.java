package com.ck.edu.api;


import com.ck.edu.utils.R;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
public class UploadController {

    public String getSavePath() {
        // 这里需要注意的是ApplicationHome是属于SpringBoot的类
        // 获取项目下resources/static/img路径
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());

        // 保存目录位置根据项目需求可随意更改
        return applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "\\src\\main\\resources\\static\\";
    }

    @PostMapping("/upload")
    public R handleFileUplaod(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
        if(file.isEmpty()) {
            return R.error().message("请上传一个文件");
        }
        try {
            byte[] bytes = file.getBytes();
            String uploadDir = getSavePath();

            String fileName = UUID.randomUUID() + "." + file.getContentType()
                    .substring(file.getContentType().lastIndexOf("/") + 1);

            File uploadFile = new File(uploadDir + fileName);
            file.transferTo(uploadFile);
//            String url = req.getScheme() + "://" + req.getServerName() + req.getServerPort() +fileName;
            String url = "http://localhost:8001/" + fileName;
            return R.ok().data("url", url);
        } catch (IOException e) {
            e.printStackTrace();
            return R.error().message("上传文件失败");
        }
    }
}
