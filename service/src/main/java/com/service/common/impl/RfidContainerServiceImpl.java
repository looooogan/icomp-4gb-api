package com.service.common.impl;


import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.RfidContainer;
import com.common.vo.RfidContainerVO;
import com.service.common.IRfidContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName RfidContainerServiceImpl
* @Description RfidContainer业务实现类
* @author Jivoin
*/
@Service("rfidContainerService")
public class RfidContainerServiceImpl implements IRfidContainerService{

    @Autowired
    private IRfidContainerMapper rfidContainerMapper;



    /**
    * @Title: addRfidContainer
    * @Description: 新增RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    @Override
    public void addRfidContainer(RfidContainer rfidContainer) throws Exception{
        rfidContainerMapper.addRfidContainer(rfidContainer);
    }

    /**
    * @Title: delRfidContainer
    * @Description: 删除RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    @Override
    public void delRfidContainer(RfidContainer rfidContainer) throws Exception{
        rfidContainerMapper.delRfidContainer(rfidContainer);
    }

    /**
    * @Title: delRfidContainerForLogic
    * @Description: 逻辑删除RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    @Override
    public void delRfidContainerForLogic(RfidContainer rfidContainer) throws Exception{
        rfidContainerMapper.delRfidContainerForLogic(rfidContainer);
    }

    /**
    * @Title: delRfidContainerByVo
    * @Description: 根据条件删除RfidContainer
    * @param rfidContainerVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delRfidContainerByVo(RfidContainerVO rfidContainerVO) throws Exception{
        rfidContainerMapper.delRfidContainerByVo(rfidContainerVO);
    }

    /**
    * @Title: updRfidContainer
    * @Description: 动态更新RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    @Override
    public void updRfidContainer(RfidContainer rfidContainer) throws Exception{
        rfidContainerMapper.updRfidContainer(rfidContainer);
    }

    /**
    * @Title: getRfidContainerByPage
    * @Description: 分页查询
    * @param rfidContainerVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<RfidContainer> getRfidContainerByPage(RfidContainerVO rfidContainerVO) throws Exception{
        rfidContainerVO.setTotalPage(rfidContainerMapper.getRfidContainerCount(rfidContainerVO));
        return rfidContainerMapper.getRfidContainerByPage(rfidContainerVO);
    }

    /**
    * @Title: getRfidContainerCount
    * @Description: 获取记录数量
    * @param rfidContainerVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getRfidContainerCount(RfidContainerVO rfidContainerVO) throws Exception{
        return rfidContainerMapper.getRfidContainerCount(rfidContainerVO);
    }

    /**
    * @Title: getRfidContainer
    * @Description: 根据查询条件查询
    * @param rfidContainerVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public RfidContainer getRfidContainer(RfidContainerVO rfidContainerVO) throws Exception{
        return rfidContainerMapper.getRfidContainer(rfidContainerVO);
    }

}
