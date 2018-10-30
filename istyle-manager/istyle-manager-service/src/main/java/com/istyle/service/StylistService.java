package com.istyle.service;

import com.istyle.pojo.TbStylist;

import java.util.List;

/**
 * 造型师接口
 * @author 黄文伟
 */
public interface StylistService {

    /**
     * 造型师注册
     * @param tbStylist
     */
    void stylistRegister(TbStylist tbStylist);
}
