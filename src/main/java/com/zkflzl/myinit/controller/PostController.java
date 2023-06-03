package com.zkflzl.myinit.controller;

import com.google.gson.Gson;
import com.zkflzl.myinit.common.BaseResponse;
import com.zkflzl.myinit.common.ErrorCode;
import com.zkflzl.myinit.exception.BusinessException;
import com.zkflzl.myinit.model.dto.post.PostAddRequest;
import com.zkflzl.myinit.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子接口
 *
 * @author <a href="https://github.com/zkflzl">程序员zk</a>
 */

@Slf4j
@Api(tags = "用户管理")
@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;


    private final static Gson GSON = new Gson();

    // region 增删改查


    // endregion

    /**
     * 创建
     *
     * @param postAddRequest
     * @param request
     * @return
     */
    @ApiOperation("添加帖子")
    @PostMapping("/add")
    public BaseResponse<Long> addPost(@RequestBody PostAddRequest postAddRequest, HttpServletRequest request) {
        if (postAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return postService.addPost(postAddRequest,request);
    }

}
