package com.zoe.phip.register.service.internal;

import com.zoe.phip.infrastructure.entity.ServiceResultT;
import com.zoe.phip.register.model.MedicalStaffInfo;

/**医护人员注册服务
 * Created by zengjiyang on 2016/4/11.
 */
public interface IMedicalStaffRegisterIn {
    /**
     * 医护人员注册
     * @param message
     * @return
     */
    ServiceResultT<MedicalStaffInfo> addProvider(MedicalStaffInfo message);

    /**
     * 	医护人员信息更新
     * @param message
     * @return
     */
    ServiceResultT<MedicalStaffInfo> updateProvider(MedicalStaffInfo message);

    /**
     * 医护人员查询
     * @param staffId
     * @return
     */
    ServiceResultT<MedicalStaffInfo> providerDetailsQuery(String staffId);
}
