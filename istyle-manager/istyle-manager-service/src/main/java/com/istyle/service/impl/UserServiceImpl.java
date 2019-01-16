package com.istyle.service.impl;

import com.exception.AppAuthException;
import com.exception.AppUnknownException;
import com.istyle.mapper.*;
import com.istyle.pojo.*;
import com.istyle.service.UserService;
import com.util.CastUtil;
import com.util.JWT;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 黄文伟
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbUserUserMapper tbUserUserMapper;
    @Autowired
    private TbSubmissionMapper tbSubmissionMapper;
    @Autowired
    private TbStylistMapper tbStylistMapper;
    @Autowired
    private TbStyHouseMapper tbStyHouseMapper;
    @Autowired
    private TbEvaluationMapper tbEvaluationMapper;
    @Autowired
    private TbStyHouseStylistMapper tbStyHouseStylistMapper;

    /**
     * 注册用户
     * @param user 用户数据，包括昵称，密码，号码，性别，年龄
     */
    @Override
    public void insertUser(TbUser user){
        if (StringUtil.isEmpty(user.getUserName())){
            throw new AppAuthException("昵称为空");
        }
        if (StringUtil.isEmpty(user.getUserPassword())) {
            throw new AppAuthException("密码为空");
        }
        if (StringUtil.isEmpty(user.getUserPhone())) {
            throw new AppAuthException("号码为空");
        }
        if (StringUtil.isEmpty(user.getUserSex())) {
            throw new AppAuthException("性别为空");
        }
        if (StringUtil.isEmpty(CastUtil.castString(user.getUserAge()))) {
            throw new AppAuthException("年龄为空");
        }
        if (tbUserMapper.isUserPhone(user.getUserPhone()) != 0) {
            throw new AppAuthException("号码已注册");
        }
        if (tbUserMapper.isUserName(user.getUserName()) != 0) {
            throw new AppAuthException("昵称已注册");
        }

        // 向数据库增加用户数据
        tbUserMapper.insertUser(user);

        // 根据号码和密码查询数据库是否有数据
        if (tbUserMapper.isNameAndPassword(user) != 1) {
            throw new AppUnknownException("注册失败");
        }
    }

    /**
     * 用户登录
     * @param user 用户数据，包括号码和密码
     * @return stoken
     */
    @Override
    public Map loginUser(TbUser user) {
        Map<String, String> stokenMap = null;

        if (tbUserMapper.isNameAndPassword(user) != 1) {
            throw new AppAuthException("号码和密码错误");
        }
        if (tbUserMapper.isUserPhone(user.getUserPhone()) != 1) {
            throw new AppAuthException("号码错误");
        }
        TbUser tbUser = tbUserMapper.loginUser(user);
        if (tbUser == null) {
            throw new AppAuthException("登录错误");
        }

        // 获得stoken
        String stoken = JWT.sign(tbUser, 24L * 3600L * 30L);

        if (StringUtil.isNotEmpty(stoken)) {
            stokenMap = new HashMap<>(16);
            stokenMap.put("stoken", stoken);

            return stokenMap;
        } else {
            throw new AppUnknownException("获取stoken失败，用户登录错误");
        }
    }

    /**
     * 登录后跳转主页返回用户名
     * @param user id
     * @return userName
     */
    @Override
    public Map<String, String> afterLoginGetName(TbUser user) {
        String userName;

        userName = user.getUserName();

        if (StringUtil.isEmpty(userName)) {
            throw new AppAuthException("登陆失败，请重新登陆");
        }
        if (userName.equals(tbUserMapper.selectUserNameById(user.getUserId()))) {
            Map<String, String> map = new HashMap<>(16);
            map.put("userName", userName);
            return map;
        }
        else {
            throw new AppAuthException("登陆失败，请重新登陆");
        }
    }

    /**
     * 查询我的信息数据
     * @param user 用户数据，包括id
     * @return TbUser
     */
    @Override
    public TbUser selectUserByUserId(TbUser user) {
        long id = user.getUserId();
        TbUser tbUser = null;

        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            tbUser = tbUserMapper.selectUserById(id);
        }
        else {
            throw new AppAuthException("在我的信息展示时，发现用户id为空，操作错误。");
        }

        return tbUser;
    }

    /**
     * 修改用户信息
     * @param beforeUser 用户修改前数据
     * @param afterUser 用户修改后数据
     */
    @Override
    public void updateUser(TbUser beforeUser, TbUser afterUser) {
        long id = beforeUser.getUserId();
        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            afterUser.setUserId(id);
            tbUserMapper.updateById(afterUser);
        } else {
            throw new AppAuthException("在修改用户信息时，发现用户ID为空，操作错误。");
        }
    }

    /**
     * 查询我的收藏数据
     * @param user 用户数据，包括id
     * @return Map 包括styCount（造型师数），styHouseCount（造型屋数），evalCount（测评数），
     *          stylists（造型师数据），styHouses（造型屋数据），evaluations（测评数据）
     */
    @Override
    public Map selectCollection(TbUser user) {
        long id = user.getUserId();
        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            Map<String, List> collections = new HashMap<>(16);
            long styCount; // 造型师收藏数
            long styHouseCount; // 造型师收藏数
            long evalCount; // 测评数
            List<TbStylist> stylists; // 造型师
            List<TbStyHouse> styHouses; // 造型屋
            List<TbEvaluation> evaluations; // 测评

            styCount = tbStylistMapper.selectStylistCountByUserId(id);
            stylists = tbStylistMapper.selectStylistByUserId(id);
            styHouseCount = tbStyHouseMapper.selectStyHouseCountByUserId(id);
            styHouses = tbStyHouseMapper.selectStyHouseByUserId(id);
            evalCount = tbEvaluationMapper.selectEvalCountByUserId(id);
            evaluations = tbEvaluationMapper.selectEvalByUserId(id);

            collections.put("styCount", Collections.singletonList(styCount));
            collections.put("stylist", stylists);
            collections.put("styHouseCount", Collections.singletonList(styHouseCount));
            collections.put("styHouse", styHouses);
            collections.put("evalCount", Collections.singletonList(evalCount));
            collections.put("evaluation", evaluations);

            return collections;
        }else {
            throw new AppAuthException("在查询我的收藏数据时，发现用户ID为空，操作错误。");
        }
    }

    /**
     * 查询我的关注数据
     * @param user 用户数据，包括id
     * @return Map 包括attentionCount（关注数），attentions（关注用户数据）
     */
    @Override
    public Map selectAttentionsById(TbUser user) {
        long id = user.getUserId();
        Map<String, List> follers = new HashMap<>(16);
        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            Long count = tbUserMapper.selectUserCountById(id);
            List<TbUser> users = tbUserMapper.selectPhotoNameWordById(id);

            follers.put("attentionCount", Collections.singletonList(count));
            follers.put("attentions", users);

            return follers;
        }
        else {
            throw new AppAuthException("在我的关注展示时，发现用户id为空，操作错误。");
        }
    }

    /**
     * 取消关注功能
     * @param user 用户数据，包括id
     * @param id2 被取消关注用户的id
     */
    @Override
    public void unFollow(TbUser user, long id2) {
        long id = user.getUserId();

        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            TbUserUser tbUserUser = new TbUserUser();
            tbUserUser.setUserId(id);
            tbUserUser.setUserId2(id2);
            tbUserUserMapper.updateUsersStateTo1(tbUserUser);
            int flag = tbUserUserMapper.selectUsersStateById(tbUserUser);

            if (flag != 1){
                throw new AppUnknownException("取消关注失败。");
            }
        }
        else {
            throw new AppAuthException("在取消关注时，发现用户id为空，操作错误。");
        }
    }

    /**
     * 查询我的粉丝数据
     * @param user 用户数据，包括id
     * @return fans Map，包括:fanCount(粉丝数), users(粉丝数据), usersState(是否关注)
     */
    @Override
    public Map myFansPage(TbUser user) {
        Long fanCount;
        List<TbUser> users ;
        List<Integer> usersState = new ArrayList<>();
        Map<String, List> fans = new HashMap<>(16);
        TbUserUser tbUserUser = new TbUserUser();
        List<Long> fanId;
        Integer flag;

        long id = user.getUserId();
        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            // 获取粉丝数量
            fanCount = tbUserUserMapper.selectFanCountByUserId2(id);
            // 获取粉丝
            users =tbUserUserMapper.selectUsersByUserId2(id);
            // 获取粉丝id
            fanId = tbUserUserMapper.selectUserIdByUserId2(id);

            tbUserUser.setUserId(id);
            for (Long param : fanId) {
                tbUserUser.setUserId2(param);
                flag = tbUserUserMapper.selectUsersStateById(tbUserUser);
                // 0为关注，1为未关注
                if (flag == null) {
                    usersState.add(1);
                } else {
                    usersState.add(flag);
                }

            }
            fans.put("fanCount", Collections.singletonList(fanCount));
            fans.put("fans", users);
            fans.put("usersState", usersState);

            return fans;
        }
        else {
            throw new AppAuthException("在我的粉丝展示时，发现用户id为空，操作错误。");
        }
    }

    /**
     * 粉丝关注功能
     * @param user 用户数据
     * @param id2 粉丝id
     */
    @Override
    public void addFollow(TbUser user, long id2) {
        Integer flag;

        long id = user.getUserId();

        // 判断用户是否曾关注过，如果没有，则增加关注；如果关注后取关，则修改关注
        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            TbUserUser tbUserUser = new TbUserUser();
            tbUserUser.setUserId(id);
            tbUserUser.setUserId2(id2);
            flag = tbUserUserMapper.selectUsersStateById(tbUserUser);
            if (flag == null){
                tbUserUserMapper.addUserStateTo0(tbUserUser);
            } else {
                tbUserUserMapper.updateUsersStateTo0(tbUserUser);
            }
            flag = tbUserUserMapper.selectUsersStateById(tbUserUser);

            if (flag != 0) {
                throw new AppUnknownException("关注失败。");
            }
        } else {
            throw new AppAuthException("在添加粉丝关注时，发现用户id为空，操作错误。");
        }
    }

    /**
     * 查询我的投稿数据
     * @param user 用户数据，包括id
     * @return map 包括submissionCount（投稿数），submissions（投稿数据）
     */
    @Override
    public Map mySubmission(TbUser user) {
        HashMap<String, List> map = new HashMap<>(16);
        List<TbSubmission> submissions;
        Long subCount;

        long id = user.getUserId();

        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            subCount = tbSubmissionMapper.selectSubCountByUserId(id);
            submissions = tbSubmissionMapper.findSubmissionIdByUserId(id);

            map.put("submissionCount", Collections.singletonList(subCount));
            map.put("submissions", submissions);

            return map;
        }else {
            throw new AppAuthException("在我的投稿展示时，发现用户id为空，操作错误。");
        }
    }

    /**
     * 用户浏览造型屋
     * @param styHousePosition
     * @return
     */
    @Override
    public Map browseStyHouse(String styHousePosition) {
        if (StringUtil.isNotEmpty(styHousePosition)) {
            Map<String, List> map = new HashMap<>(16);
            List<TbStyHouse> styHouses;
            List<TbStylist> stylists = new ArrayList<>(4);

            styHouses = tbStyHouseMapper.selectPhotoNameAddressPackageByPosition(styHousePosition);

            // 遍历造型屋，获得每个造型屋的造型师
            outer: for (int i = 0; i < styHouses.size(); i++) {
                List<Long> stylistId = tbStyHouseStylistMapper.selectStylistIdByStyHouseId(styHouses.get(i).getStyHouseId());
                //遍历造型师，获得每个造型师的数据
                for (int j = 0; j < stylistId.size(); j++) {
                    stylists = tbStylistMapper.selectPhotoAndNameById(stylistId.get(j));
                    // 如果容器多于4个，就跳出外循环
                    if (stylists.size() > 4) {
                        break outer;
                    }
                }
            }

            map.put("styHouses", styHouses);
            map.put("stylists", stylists);

            return map;
        } else {
            throw new AppAuthException("造型屋地址为空。");
        }
    }
}
