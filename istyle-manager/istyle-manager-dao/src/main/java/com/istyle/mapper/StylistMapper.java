package com.istyle.mapper;

import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.pojo.TbStylist;

public interface StylistMapper {
	/**
     * 联合查找造型屋和造型师
     * @param  stylistId
     * @return
     */
	public TbStyHouseStylist SelectTbStyHouseStylistBystylistId(long stylistId);
	
	 /**
     * 更新造型师
     * @param 
     * @return Response
     */
    public boolean updateStylistMessage1(TbStylist tbStylist);
    
    /**
     * 更新造型师
     * @param 
     * @return Response
     */
    public boolean updateStylistMessage2(TbStyHouseStylist tbStyHouseStylist);
    
}
