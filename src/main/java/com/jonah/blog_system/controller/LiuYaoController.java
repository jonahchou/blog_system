package com.jonah.blog_system.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.jonah.blog_system.common.Content;
import com.jonah.blog_system.common.Result;
import com.jonah.blog_system.entity.extend.LiuYaoExtend;
import com.jonah.blog_system.excption.MyException;
import com.jonah.blog_system.service.LiuYaoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Jonah
 * @date 2023/5/30 9:33
 */
@RestController
@RequestMapping("/liuYao")
@Slf4j
public class LiuYaoController {

    @Resource
    private LiuYaoService liuYaoService;

    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    @PostMapping("/saveOrUpdateLiuYao")
    public String updateOrSaveLiuYao(@RequestBody LiuYaoExtend liuYaoExtend){
        Result json;
        try {
            liuYaoService.saveOrUpdateLiuYao(liuYaoExtend);
            json = Result.success(Content.CAOZUO_SUCCESS);
        }catch (MyException e){
            log.info("************************业务处理异常**********************");
            log.info("异常信息：{}", e);
            json = Result.error(e.getMessage());
        }catch (Exception e){
            log.warn("*************************非业务处理异常***********************");
            log.warn("异常信息：{}",e);
            json = Result.error("六爻保存失败");
        }
        return JSON.toJSONString(json);
    }

    @PostMapping("/deleteLiuYao")
    public String deleteLiuYao(@RequestBody List<Integer> ids){
        Result json;
        try {
            liuYaoService.delLiuYao(ids);
            json = Result.success(Content.CAOZUO_SUCCESS);
        }catch (MyException e){
            log.info("************************业务处理异常**********************");
            log.info("异常信息：{}", e);
            json = Result.error(e.getMessage());
        }catch (Exception e){
            log.warn("*************************非业务处理异常***********************");
            log.warn("异常信息：{}",e);
            json = Result.error("六爻删除失败");
        }
        return JSON.toJSONString(json);
    }

    @GetMapping("/findLiuYaoPage")
    public String findLiuYaoPage(LiuYaoExtend liuYaoExtend){
        Result json;
        try {
            json = Result.success(Content.CAOZUO_SUCCESS, liuYaoService.findLiuYaoPage(liuYaoExtend));
        }catch (MyException e){
            log.info("************************业务处理异常**********************");
            log.info("异常信息：{}", e);
            json = Result.error(e.getMessage());
        }catch (Exception e){
            log.warn("*************************非业务处理异常***********************");
            log.warn("异常信息：{}",e);
            json = Result.error("六爻查询失败");
        }
        return JSON.toJSONString(json);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            Path path = Paths.get(uploadDir, fileName);
            Files.write(path, file.getBytes());
            return ResponseEntity.ok()
                    .body("/uploadPath/" + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
