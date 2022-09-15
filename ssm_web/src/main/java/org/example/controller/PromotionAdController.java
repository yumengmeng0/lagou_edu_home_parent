package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.domain.PromotionAd;
import org.example.domain.PromotionAdVO;
import org.example.domain.ResponseResult;
import org.example.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * 广告
 *
 * @author
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
        return new ResponseResult(true, 200, "广告分页查询成功", pageInfo);
    }

    /**
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/promotionAdUpload")
    public ResponseResult promotionAdUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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

        return new ResponseResult(true, 200, "图片上传成功", map);
    }

    /**
     * 广告上下线
     *
     * @return
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        promotionAdService.updatePromotionAdStatus(id, status);
        return new ResponseResult(true, 200, "广告上下线成功", null);
    }

    /**
     * 根据广告id查询广告信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam("id") Integer id) {
        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
        return new ResponseResult(true, 200, "根据space id查询广告位信息成功", promotionAd);
    }

    /**
     * 更新或修改广告
     *
     * @param promotionAd
     * @return
     */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd) {
        System.out.println("promotionAd = " + promotionAd);
        // 注意：不要把条件弄反，当promotionAdService.updatePromotionAd(promotionAd);的promotionAd的id为null时，会造成全表更新
        if (promotionAd.getId() == null) {
            promotionAdService.savePromotionAd(promotionAd);
            return new ResponseResult(true, 200, "保存广告位信息成功", null);
        } else {
            promotionAdService.updatePromotionAd(promotionAd);
            return new ResponseResult(true, 200, "更新广告位信息成功", null);
        }
    }
}
