package com.istyle.service;

import com.istyle.pojo.TbStylist;

import java.util.List;


public interface StylistService {
//    查询造型师数量
    Long selectStylistCountByUserId(Long userId);
//    查询造型师昵称及图片
    List<TbStylist> selectStylistByUserId(Long userId);
}
