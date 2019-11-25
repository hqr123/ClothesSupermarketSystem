package com.vince.service.impl;

import com.vince.bean.Clothes;
import com.vince.service.ClothesService;
import com.vince.utils.BusinessException;
import com.vince.utils.ProductsXMLUtils;

import java.util.List;

public  class ClothesServiceImpl implements ClothesService{


    @Override
    public List<Clothes> list() throws BusinessException {
        List<Clothes> clothes = ProductsXMLUtils.parserProductFormXml();
        return clothes;
    }

    @Override
    public Clothes findById(int cid) throws BusinessException {
        return null;
    }
}
