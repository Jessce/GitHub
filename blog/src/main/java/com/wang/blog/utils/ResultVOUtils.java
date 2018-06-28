package com.wang.blog.utils;

import com.wang.blog.VO.ResultVO;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 21:03 2018/6/28
 * @ Description：
 * @ Modified By：
 */
public class ResultVOUtils {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
