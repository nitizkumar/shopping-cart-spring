package com.learnithardway.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl implements WineService{

    @Resource
    private WineDao dao;

    public void setDao(WineDao dao) {
        this.dao = dao;
    }

    @Override
    public List<WineDetail> getListOfWines() {
        return dao.getListOfWines();
    }
}
