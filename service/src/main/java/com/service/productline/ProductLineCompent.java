package com.service.productline;

import com.common.pojo.*;
import com.common.vo.ProductLineVO;
import com.common.vo.SynthesisCuttingToolLocationVO;
import com.service.common.IDjItrnAkpService;
import com.service.common.IProductLineService;
import com.service.common.ISynthesisCuttingToolBindService;
import com.service.common.ISynthesisCuttingToolLocationService;
import com.service.productline.bo.ProductLineBO;
import com.service.writeback.IDjWriteBackService;
import com.service.writeback.bo.InstallWBBO;
import com.service.writeback.bo.UnInstallWBBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by logan on 2018/5/12.
 */

@Component("ProductLineCompent")
public class ProductLineCompent {
    @Autowired
    private IProductLineBusinessService productLineBusinessService;
    @Autowired
    private ISynthesisCuttingToolBindService synthesisCuttingToolBindService;
    @Autowired
    private IProductLineService productLineService;
    @Autowired
    private ISynthesisCuttingToolLocationService locationService;
    @Autowired
    private IDjWriteBackService writeBackService;

    /**
     * 安上设备
     * @param productLineBO
     * @throws Exception
     */
    public void install(ProductLineBO productLineBO) throws Exception{
        productLineBusinessService.installData(productLineBO);
        //回写数据
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindService.getSynthesisCuttingToolBind(productLineBO.getSynthesisCuttingToolBindVO());
        ProductLineVO productLineVO = new ProductLineVO();
        productLineVO.setEquipmentCode(productLineBO.getProductLineEquipmentVO().getCode());
        productLineVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingTool().getCode());
        ProductLine productLine = productLineService.getAssemblylineByEquipmentAndAxle(productLineVO);
        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        List<SynthesisCuttingToolLocation> locations = locationService.getSynthesisCuttingToolLocationByPage(locationVO);
        InstallWBBO installWBBO = new InstallWBBO();
        installWBBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        installWBBO.setLocationList(locations);
        installWBBO.setProductLine(productLine);
        installWBBO.setLoginUser(productLineBO.getLoginUser());
        writeBackService.writeBackInstall(installWBBO);
    }

    /**
     * 卸下设备
     * @param productLineBO
     * @throws Exception
     */
    public void UnInstall(ProductLineBO productLineBO) throws Exception{
        productLineBO = productLineBusinessService.unInstallData(productLineBO);
        //回写数据
        UnInstallWBBO unInstallWBBO = new UnInstallWBBO();
        unInstallWBBO.setBindleRecords(productLineBO.getBindleRecords());
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindService.getSynthesisCuttingToolBind(productLineBO.getSynthesisCuttingToolBindVO());
        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        List<SynthesisCuttingToolLocation> locations = locationService.getSynthesisCuttingToolLocationByPage(locationVO);
        unInstallWBBO.setLocationList(locations);
        unInstallWBBO.setLoginUser(productLineBO.getLoginUser());
        writeBackService.writeBackUnInstall(unInstallWBBO);
    }

}
