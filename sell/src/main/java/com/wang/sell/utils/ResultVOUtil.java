package com.wang.sell.utils;

import com.wang.sell.VO.ResultVO;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 17:12 2018/5/24
 * @ Description：用来创建最外层对象的工具类
 * @ Modified By：
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String message){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
