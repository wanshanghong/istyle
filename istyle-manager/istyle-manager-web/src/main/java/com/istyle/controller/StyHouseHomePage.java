package com.istyle.controller;

import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStyHousePackage;
import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.service.StyHouseService;
import com.util.JWT;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 21:49 2019/3/26
 */
@Controller
@RequestMapping("/styHouseHome")
public class StyHouseHomePage {
    @Autowired
    private StyHouseService styHouseService;

    /**
     * 造型屋信息主页
     * @param request
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response styHouseIndex(@RequestBody Map<String, String> request) {
        TbStyHouse styHouse = JWT.unsign(request.get("stoken"), TbStyHouse.class);
        TbStyHouse param = styHouseService.showStyHouseIndex(styHouse);
        return Response.ok(param);
    }

    /**
     * 造型屋主页信息编辑页面
     * @param styHouseId
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/editMessage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editMessage(@PathVariable(value = "styHouseId") Long styHouseId) {
        TbStyHouse param = styHouseService.showEditMessage(styHouseId);
        return Response.ok(param);
    }

    /**
     * 造型屋主页信息修改
     * @param styHouseId
     * @param styHouse
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/updateMessage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editMessage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouse styHouse/*, @CookieValue(value = "stoken") String stoken*/) {
        styHouseService.updateEditMessage(styHouse);
        return Response.ok();
    }

    /**
     * 套餐管理展示
     * @param styHouseId
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/packageManager", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response packageManager(@PathVariable(value = "styHouseId") Long styHouseId) {
        Map param = styHouseService.showPackageManager(styHouseId);
        return Response.ok(param);
    }

    /**
     * 套餐发布
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/submitPackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response packageManager(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
        boolean flag = styHouseService.submitPackage(tbStyHousePackage);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("套餐发布失败，请重新发布");
        }
    }

    /**
     * 套餐管理编辑展示
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/editPackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editPackage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
        TbStyHousePackage param = styHouseService.showeditPackage(tbStyHousePackage);
        return Response.ok(param);
    }

    /**
     * 套餐管理信息修改
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/submitEditPackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response submitEditPackage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
        boolean flag = styHouseService.submitEditPackage(tbStyHousePackage);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("套餐修改失败");
        }
    }

    /**
     * 套餐删除
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/deletePackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response deletePackage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
        boolean flag = styHouseService.deletePackage(tbStyHousePackage);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("套餐删除失败");
        }
    }

    /**
     * 造型师管理展示
     * @param styHouseId
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/stylistManager", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response stylistManager(@PathVariable(value = "styHouseId") Long styHouseId) {
        Map param = styHouseService.selectStylistManager(styHouseId);
        return Response.ok(param);
    }

    /**
     * 造型师编辑界面展示
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/editStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        TbStyHouseStylist param = styHouseService.selectStylist(tbStyHouseStylist);
        return Response.ok(param);
    }

    /**
     * 造型师信息修改
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/submitEditStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response submitEditStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        boolean flag = styHouseService.submitEditStylist(tbStyHouseStylist);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("造型师信息修改失败");
        }
    }

    //TODO 需用户填写造型师id进行造型师绑定
    /**
     * 造型师发布
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/submitStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response submitStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        boolean flag = styHouseService.submitStylist(tbStyHouseStylist);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("造型师发布失败");
        }
    }

    /**
     * 造型师删除
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/deleteStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response deleteStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        boolean flag = styHouseService.deleteStylist(tbStyHouseStylist);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("造型师删除失败");
        }
    }
}
