package com.istyle.service;

import java.util.List;

import com.istyle.pojo.TbHair;

public interface HairService {
	 /**
     * 查找所有的头发
     * @param 
     * @return List<TbHair>
     */
	public List<TbHair> SelectAllHair();

	/**
     * 通过分类查找所有的头发
     * @param TbHair tbHair
     * @return List<TbHair>
     */
	public List<TbHair> SelectHairByHairClass(TbHair tbHair);
}
