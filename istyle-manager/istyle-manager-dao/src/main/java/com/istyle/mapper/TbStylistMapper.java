package com.istyle.mapper;

import com.istyle.pojo.TbStylist;

import java.util.List;

public interface TbStylistMapper {
    Long selectStylistCountByUserId(Long userId);
    List<TbStylist> selectStylistByUserId(Long userId);
}
