package com.service.orders.impl;

import com.common.constants.QiMingOrderEnum;
import com.common.mapper.IDjCircleKanbanAkpMapper;
import com.common.mapper.IDjMtlAkpMapper;
import com.common.mapper.IDjOutapplyAkpMapper;
import com.common.pojo.DjCircleKanbanAkp;
import com.common.pojo.DjMtlAkp;
import com.common.pojo.DjOutapplyAkp;
import com.common.utils.MD5;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.DjCircleKanbanAkpVO;
import com.common.vo.DjMtlAkpVO;
import com.common.vo.DjOutapplyAkpVO;
import com.service.orders.IDjQiMingDBService;
import com.service.orders.vo.OutApplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by logan on 2018/5/11.
 */
@Service("DjQiMingDBService")
public class DjQiMingDBServiceImpl implements IDjQiMingDBService{

    @Autowired
    private IDjOutapplyAkpMapper djOutapplyAkpMapper;
    @Autowired
    private IDjCircleKanbanAkpMapper djCircleKanbanAkpMapper;
    @Autowired
    private IDjMtlAkpMapper djMtlAkpMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;


    /**
     *
     * @param outApplyVO
     * @return
     * @throws Exception
     */
    @Override
    public OutApplyVO getInfo(OutApplyVO outApplyVO) throws Exception {
        DjOutapplyAkpVO djOutapplyAkpVO = new DjOutapplyAkpVO();
        djOutapplyAkpVO.setApplyno(outApplyVO.getApplyno());
        djOutapplyAkpVO.setAuditid(QiMingOrderEnum.approved.getKey());
        DjOutapplyAkp djOutapplyAkp = djOutapplyAkpMapper.getDjOutapplyAkp(djOutapplyAkpVO);
        outApplyVO.setDjOutapplyAkp(djOutapplyAkp);


        DjCircleKanbanAkpVO kanbanAkpVO = new DjCircleKanbanAkpVO();
        kanbanAkpVO.setCKanbanCode(djOutapplyAkp.getLltm());
        DjCircleKanbanAkp djCircleKanbanAkp = djCircleKanbanAkpMapper.getDjCircleKanbanAkp(kanbanAkpVO);
        outApplyVO.setDjCircleKanbanAkp(djCircleKanbanAkp);


        DjMtlAkpVO djMtlAkpVO = new DjMtlAkpVO();
        djMtlAkpVO.setMtlCode(djCircleKanbanAkp.getMtlCode());
        DjMtlAkp djMtlAkp = djMtlAkpMapper.getDjMtlAkp(djMtlAkpVO);
        outApplyVO.setDjMtlAkp(djMtlAkp);

        Integer susr20 = 0;
        Integer unitqty = 0;
        try {
            susr20 = Integer.parseInt(djMtlAkp.getSusr20());
            unitqty = Integer.parseInt(djOutapplyAkp.getUnitqty());
        }catch (Exception e){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.QM_SUSR20_UNITQTY_CHANGE_ERROR));
        }

        outApplyVO.setDjCircleKanbanAkp(djCircleKanbanAkp);
        outApplyVO.setDjMtlAkp(djMtlAkp);
        outApplyVO.setDjOutapplyAkp(djOutapplyAkp);
        outApplyVO.setSusr20(susr20);
        outApplyVO.setMaxDJH(susr20);
        outApplyVO.setUnitqty(unitqty);
        return outApplyVO;
    }

    /**
     * 修改启明数据库数据
     * @param outApplyVO
     * @throws Exception
     */
    @Override
    public void updateDjOutapplyAkpForOut(OutApplyVO outApplyVO) throws Exception {
        //修改出库单
        DjOutapplyAkp djOutapplyAkp = outApplyVO.getDjOutapplyAkp();
        djOutapplyAkp.setAuditid("2");
        djOutapplyAkpMapper.updDjOutapplyAkp(djOutapplyAkp);
        //更新最大刀头号
        DjMtlAkp djMtlAkp = outApplyVO.getDjMtlAkp();
        djMtlAkp.setSusr20(outApplyVO.getSusr20()+"");
        djMtlAkpMapper.updDjMtlAkp(djMtlAkp);
    }

    public static void main(String[] args) {
        System.out.println(MD5.getMD5("111111"));
    }
}
