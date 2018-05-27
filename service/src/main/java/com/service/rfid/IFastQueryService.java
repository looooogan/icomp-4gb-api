package com.service.rfid;

import com.service.rfid.vo.FastQueryVO;

/**
 * Created by logan on 2018/5/27.
 */
public interface IFastQueryService {

    /**
     * @Title: fastQuery
     * @Description: 快速查询
     * @param fastQueryVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public FastQueryVO fastQuery(FastQueryVO fastQueryVO) throws Exception;


    /**
     * @Title: querySyn
     * @Description: 获取菜单权限列表
     * @param fastQueryVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public FastQueryVO querySyn(FastQueryVO fastQueryVO) throws Exception;

}
