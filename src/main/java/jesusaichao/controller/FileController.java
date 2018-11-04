package jesusaichao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: Jesusaichao
 * @Created With By IDEA
 * @Description: Class
 * Date: 18.10.19
 * Time: 10:44
 */
@Controller
@RequestMapping("/file")
public class FileController {
    /**
     *文件上传
     * @return
     */
    @RequestMapping("/fileUpLoad")
    public String fileUpLoad(MultipartFile file, String username, HttpServletRequest request) throws IOException {
        //创建文件名称
        String filename = file.getOriginalFilename();
        //设置文件唯一名称
        filename = UUID.randomUUID().toString() + filename;
        //设置文件路径
        String realPath = request.getSession().getServletContext().getRealPath("upload");
        //设置子路径
        String childPath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("realPath = " + realPath);
        System.out.println(username);
        //创建文件
        File files = new File(realPath, childPath);
        //判断文件是否存在
        if (!files.exists()) {
            files.mkdirs();
        }
        //创建上传文件
        File upLoadFile = new File(files, filename);
        //上传文件
        file.transferTo(upLoadFile);
        return "success";
    }
}
