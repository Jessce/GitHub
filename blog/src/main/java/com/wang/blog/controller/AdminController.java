package com.wang.blog.controller;

import com.wang.blog.config.ProjectUrlConfig;
import com.wang.blog.constant.CookieConstant;
import com.wang.blog.domain.AdminInfo;
import com.wang.blog.enums.ResultEnum;
import com.wang.blog.form.AdminInfoForm;
import com.wang.blog.service.AdminInfoService;
import com.wang.blog.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:30 2018/7/7
 * @ Description：管理员控制器
 * @ Modified By：
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminInfoService adminInfoService;

    @Autowired
    ProjectUrlConfig projectUrlConfig;
    
    /**
     * create by: 泽非
     * description:登陆界面展示
     * create time: 16:38 2018/7/7
     */
    @GetMapping("/index")
    public ModelAndView index(Map<String,Object> map){
        return new ModelAndView("admin/index");
    }

    /**
     * create by: 泽非
     * description:登陆,这里使用post请求的原因是为了让前端返回的是一个form表单对象，
     * 而不是接在url后面的各个参数，方便进行表单验证
     * create time: 16:32 2018/7/7
     */
    @PostMapping("/login")
    public ModelAndView login(@Valid AdminInfoForm form,
                              BindingResult bindingResult,
                              HttpServletResponse response,
                              Map<String,Object> map){
//        判断表单错误
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/blog/admin/index");
            return new ModelAndView("common/error",map);
        }

//        查找管理员信息
        AdminInfo adminInfo=adminInfoService.findByAdminname(form.getAdminname());
//        判断是否存在该管理员
        if(adminInfo==null){
            map.put("msg", ResultEnum.LOGIN_NOT_EXIST.getMsg());
            map.put("url","/blog/admin/index");
            return new ModelAndView("common/error",map);
        }
//        判断密码是否正确
        if(!adminInfo.getPassword().equals(form.getPassword())){
            map.put("msg", ResultEnum.LOGIN_ERROR.getMsg());
            map.put("url","/blog/admin/index");
            return new ModelAndView("common/error",map);
        }
//        设置token至cookie
        String token = UUID.randomUUID().toString();
        CookieUtils.set(response, CookieConstant.TOKEN,token,CookieConstant.EXPIRE);

        return new ModelAndView("redirect:"+"/manage/articles/list");
    }
    
    /**
     * create by: 泽非
     * description:登出
     * create time: 16:32 2018/7/7
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String, Object> map){
        //1. 从cookie里查询
        Cookie cookie = CookieUtils.get(request, CookieConstant.TOKEN);
        if (cookie != null) {

            //3. 清除cookie
            CookieUtils.set(response, CookieConstant.TOKEN, null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMsg());
        map.put("url", "/blog/admin/index");
        return new ModelAndView("common/success", map);
    }
}
