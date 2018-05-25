package com.wang.sell.controller;

import com.wang.sell.VO.ProductInfoVO;
import com.wang.sell.VO.ProductVO;
import com.wang.sell.VO.ResultVO;
import com.wang.sell.domain.ProductCategory;
import com.wang.sell.domain.ProductInfo;
import com.wang.sell.enums.ProductStatusEnum;
import com.wang.sell.service.impl.CategoryImpl;
import com.wang.sell.service.impl.ProductInfoServiceImpl;
import com.wang.sell.utils.ResultVOUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 16:49 2018/5/24
 * @ Description：买家看到的商品
 * @ Modified By：
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Autowired
    private CategoryImpl categoryService;

    @GetMapping("/list")
    public ResultVO list(){
//      查询所有上架商品
        List<ProductInfo> productInfos=productInfoService.findByProductStatus(ProductStatusEnum.Up.getCode());

//      查询类目（一次性查询）
//        传统方法
//        List<Integer> categoryTypeList=new ArrayList<Integer>();
//        for(ProductInfo productInfo:productInfos){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
//        新技术（java8,lambda）
        List<Integer> categoryTypeList=productInfos.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);

//    3.数据拼接
        List<ProductInfoVO> productInfoVOList=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductInfoVO productInfoVO=new ProductInfoVO();
            productInfoVO.setCategoryName(productCategory.getCategoryName());
            productInfoVO.setCategoryType(productCategory.getCategoryType());

            List<ProductVO> productVOList=new ArrayList<>();
            for(ProductInfo productInfo:productInfos){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
//                    BeanUtils.copyProperties(productInfo,productVO);
                    ProductVO productVO=new ProductVO();
                    BeanUtils.copyProperties(productInfo,productVO);
//                    productVO.setProductId(productInfo.getProductId());
//                    productVO.setProductName(productInfo.getProductName());
//                    productVO.setProductPrice(productInfo.getProductPrice());
//                    productVO.setProductDescription(productInfo.getProductDescription());
//                    productVO.setProductIcon(productInfo.getProductIcon());
                    productVOList.add(productVO);
                }
            }
            productInfoVO.setProductVOList(productVOList);
            productInfoVOList.add(productInfoVO);
        }
        return ResultVOUtil.success(productInfoVOList);
    }
}
