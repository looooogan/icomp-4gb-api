package com.service.inoutFactory;

import com.common.constants.GrindingEnum;
import com.common.constants.OperationEnum;
import com.common.constants.QiMingOptionEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.IDjItrnAkpMapper;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.DjItrnAkp;
import com.common.utils.OrderNumHandler;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.DjItrnAkpVO;
import com.service.common.ICuttingToolBindService;
import com.service.common.ICuttingToolService;
import com.service.common.IDjItrnAkpService;
import com.service.inoutFactory.vo.InsideVO;
import com.service.inoutFactory.vo.OutSideVO;
import com.service.inoutFactory.vo.SharpenVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/5/12.
 */
@Component("InOutFactoryComent")
public class InOutFactoryComent {
    @Autowired
    private IInOutFactoryService inOutFactoryService;
    @Autowired
    private ICuttingToolBindService cuttingToolBindService;
    @Autowired
    private IDjItrnAkpService djItrnAkpService;
    @Autowired
    private ICuttingToolService cuttingToolService;

    /**
     * 厂内刃磨
     * @param insideVO
     * @throws Exception
     */
    public void inSideFactory(InsideVO insideVO) throws Exception{
        inOutFactoryService.addInsideFactory(insideVO);

        DjItrnAkp djItrnAkp = null;


        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        for (SharpenVO sharpenVO : insideVO.getSharpenVOS()) {
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(sharpenVO.getCuttingToolBladeCode())){
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(sharpenVO.getCuttingToolBladeCode());
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
            }
            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            if (null != cuttingToolBind){
                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
            }
            //根据刀身码查询
            djItrnAkpVO.setDaojCase(sharpenVO.getCuttingToolBusinessCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
            if (null!= djItrnAkp){

                if (null == batchNo){
                    batchNo = 1;
                }
                CuttingToolVO cuttingToolVO = new CuttingToolVO();
                cuttingToolVO.setBusinessCode(sharpenVO.getCuttingToolBusinessCode());
                CuttingTool cuttingTool = cuttingToolService.getCuttingTool(cuttingToolVO);
                if (null == cuttingTool){
                    continue;
                }

                DjItrnAkp djItrnAkpNew = djItrnAkp;
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                if (cuttingToolBind!=null){
                    djItrnAkpNew.setJgcs(cuttingToolBind.getJgcs()+"");
                    djItrnAkpNew.setLhcs(cuttingToolBind.getLhcs()+"");
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                djItrnAkpNew.setType(QiMingOptionEnum.inside_sharpening.getKey());
                djItrnAkpNew.setNote(OperationEnum.Cutting_tool_Inside.getName());
                djItrnAkpService.addDjItrnAkp(djItrnAkpNew);
            }
        }
    }

    public void OutSideFactory(OutSideVO outSideVO) throws Exception{
        //外委单号
        String wwcode = djItrnAkpService.getMaxWWOrderNum();
        if(StringUtils.isBlank(wwcode)){
            wwcode = OrderNumHandler.orderNumInit();
        }else {
            wwcode = OrderNumHandler.getNextOrderNum(wwcode);
        }
        outSideVO.setWwcode(wwcode);
        inOutFactoryService.addOutsideFactory(outSideVO);

        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 1;
        }

        DjItrnAkp djItrnAkp = null;

        for (SharpenVO sharpenVO : outSideVO.getSharpenVOS()) {
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(sharpenVO.getCuttingToolBladeCode())){
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(sharpenVO.getCuttingToolBladeCode());
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
            }
            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            if (null != cuttingToolBind){
                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
            }
            //根据刀身码查询
            djItrnAkpVO.setDaojCase(sharpenVO.getCuttingToolBusinessCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
            if (null!= djItrnAkp){
                CuttingToolVO cuttingToolVO = new CuttingToolVO();
                cuttingToolVO.setBusinessCode(sharpenVO.getCuttingToolBusinessCode());
                CuttingTool cuttingTool = cuttingToolService.getCuttingTool(cuttingToolVO);


                DjItrnAkp djItrnAkpNew = djItrnAkp;
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                if (cuttingToolBind!=null){
                    djItrnAkpNew.setJgcs(cuttingToolBind.getJgcs()+"");
                    djItrnAkpNew.setLhcs(cuttingToolBind.getLhcs()+"");
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_coating.getKey());
                    djItrnAkpNew.setNote(OperationEnum.Cutting_tool_Inside_Coating.getName());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_sharpening.getKey());
                    djItrnAkpNew.setNote(OperationEnum.Cutting_tool_OutSide.getName());
                }
                djItrnAkpNew.setWwOwner(outSideVO.getSharpenProviderCode());
                djItrnAkpNew.setWwcode(wwcode);
                djItrnAkpNew.setZcCode(outSideVO.getZcCode());
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                djItrnAkpService.addDjItrnAkp(djItrnAkpNew);
            }
        }

    }

}