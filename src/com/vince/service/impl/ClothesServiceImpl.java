package com.vince.service.impl;

import com.vince.bean.Clothes;
import com.vince.service.ClothesService;
import com.vince.utils.BusinessException;
import com.vince.utils.ClothesIO;
import com.vince.utils.ProductsXMLUtils;

import java.util.List;

public  class ClothesServiceImpl implements ClothesService{

    private ClothesIO clothesIO = new ClothesIO();

    @Override
    public List<Clothes> list() throws BusinessException {

        return clothesIO.list();
    }

    @Override
    public Clothes findById(String cid) throws BusinessException {


        return clothesIO.findById(cid);
    }

    @Override
    public void update() throws BusinessException {
        clothesIO.update();
    }


}
