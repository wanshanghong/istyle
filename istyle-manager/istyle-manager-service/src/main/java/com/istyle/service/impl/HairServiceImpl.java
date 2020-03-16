package com.istyle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istyle.mapper.HairMapper;
import com.istyle.pojo.TbHair;
import com.istyle.service.HairService;

@Service
public class HairServiceImpl implements HairService{
	@Autowired
	private HairMapper hairMapper;
	 /**
     * 查找所有的头发
     * @param 
     * @return List<TbHair>
     */
	public List<TbHair> SelectAllHair(){
		return hairMapper.SelectAllHair();
	}

	/**
     * 通过分类查找所有的头发
     * @param TbHair tbHair
     * @return List<TbHair>
     */
	public List<TbHair> SelectHairByHairClass(TbHair tbHair){
		System.out.println("HairServiceImpltbHair="+tbHair.toString());
		return hairMapper.SelectHairByHairClass(tbHair);
	}
}
