package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IOutPrepareLibraryMapper;
import com.common.pojo.OutPrepareLibrary;
import com.common.vo.OutPrepareLibraryVO;
import com.service.common.IOutPrepareLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName OutPrepareLibraryServiceImpl
* @Description OutPrepareLibrary业务实现类
* @author Jivoin
*/
@Service("outPrepareLibraryService")
public class OutPrepareLibraryServiceImpl implements IOutPrepareLibraryService{

    @Autowired
    private IOutPrepareLibraryMapper outPrepareLibraryMapper;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addOutPrepareLibrary
    * @Description: 新增OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    @Override
    public void addOutPrepareLibrary(OutPrepareLibrary outPrepareLibrary) throws Exception{
        outPrepareLibraryMapper.addOutPrepareLibrary(outPrepareLibrary);
    }

    /**
    * @Title: delOutPrepareLibrary
    * @Description: 删除OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutPrepareLibrary(OutPrepareLibrary outPrepareLibrary) throws Exception{
        outPrepareLibraryMapper.delOutPrepareLibrary(outPrepareLibrary);
    }

    /**
    * @Title: delOutPrepareLibraryForLogic
    * @Description: 逻辑删除OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutPrepareLibraryForLogic(OutPrepareLibrary outPrepareLibrary) throws Exception{
        outPrepareLibraryMapper.delOutPrepareLibraryForLogic(outPrepareLibrary);
    }

    /**
    * @Title: delOutPrepareLibraryByVo
    * @Description: 根据条件删除OutPrepareLibrary
    * @param outPrepareLibraryVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutPrepareLibraryByVo(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception{
        outPrepareLibraryMapper.delOutPrepareLibraryByVo(outPrepareLibraryVO);
    }

    /**
    * @Title: updOutPrepareLibrary
    * @Description: 动态更新OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    @Override
    public void updOutPrepareLibrary(OutPrepareLibrary outPrepareLibrary) throws Exception{
        outPrepareLibraryMapper.updOutPrepareLibrary(outPrepareLibrary);
    }

    /**
    * @Title: getOutPrepareLibraryByPage
    * @Description: 分页查询
    * @param outPrepareLibraryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<OutPrepareLibrary> getOutPrepareLibraryByPage(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception{
        outPrepareLibraryVO.setTotalPage(outPrepareLibraryMapper.getOutPrepareLibraryCount(outPrepareLibraryVO));
        return outPrepareLibraryMapper.getOutPrepareLibraryByPage(outPrepareLibraryVO);
    }

    /**
    * @Title: getOutPrepareLibraryCount
    * @Description: 获取记录数量
    * @param outPrepareLibraryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOutPrepareLibraryCount(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception{
        return outPrepareLibraryMapper.getOutPrepareLibraryCount(outPrepareLibraryVO);
    }

    /**
    * @Title: getOutPrepareLibrary
    * @Description: 根据查询条件查询
    * @param outPrepareLibraryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public OutPrepareLibrary getOutPrepareLibrary(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception{
        return outPrepareLibraryMapper.getOutPrepareLibrary(outPrepareLibraryVO);
    }

}
