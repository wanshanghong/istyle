package com.istyle.service.util;

import com.exception.AppAuthException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: 黄文伟
 * @description: 文件上传
 * @Date:Created in 19:53 2019/2/2
 */
public class FileUpload {
    /**
     *
     * @param img 上传的图片
     * @param sqlPath 保存图片的相对位置
     * @return fileName 文件名
     * @throws IOException
     */
    public static String imgUpload(MultipartFile img, String sqlPath){
        //定义文件保存的本地路径
        String localPath = "/WEB-INF/uploadPhoto";
        // 上传时生成的临时文件保存目录
        String tempPath = "/WEB-INF/tempPhoto";

        //定义 文件名
        String filename=null;
        if(!img.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=img.getContentType();
            //获得文件后缀名
            String suffixName=contentType.substring(contentType.indexOf("/")+1);
            //得到 文件名
            filename=uuid+"."+suffixName;
            //文件保存路径
            try {
                img.transferTo(new File(localPath+sqlPath+filename));
            } catch (IOException e) {
                throw new AppAuthException("文件保存失败");
            }
        }
        //把图片的相对路径保存至数据库
/*        sqlPath = "/img/"+filename;
        System.out.println(sqlPath);
        user.setImage(sqlPath);
        userService.addUser(user);
        model.addAttribute("user", user);*/

        return filename;
    }
}
