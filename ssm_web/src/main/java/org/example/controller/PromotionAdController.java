package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.domain.PromotionAd;
import org.example.domain.PromotionAdVO;
import org.example.domain.ResponseResult;
import org.example.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/promotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    /**
     * 分页查询广告
     *
     * @param promotionAdVO
     * @return
     */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {
        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "广告分页查询成功", pageInfo);
        return responseResult;
    }

    /**
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/promotionAdUpload")
    public ResponseResult courseUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException();
        }

        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath = " + realPath);
        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));
        System.out.println("substring = " + substring);

        String originalFilename = file.getOriginalFilename();

        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
        String uploadPath = substring + "upload\\";

        File filePath = new File(uploadPath, newFileName);

        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录 = " + filePath);
        }

        file.transferTo(filePath);

        HashMap<String, String> map = new HashMap<>();
        map.put("fileName", newFileName);
        map.put("filePath", "http://localhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);
        return responseResult;
    }

    /**
     * 广告上下线
     *
     * @return
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        promotionAdService.updatePromotionAdStatus(id, status);
        ResponseResult responseResult = new ResponseResult(true, 200, "广告上下线成功", null);
        return responseResult;
    }


}
