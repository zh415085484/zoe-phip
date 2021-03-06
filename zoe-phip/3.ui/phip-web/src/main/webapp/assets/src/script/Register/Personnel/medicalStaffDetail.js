/**
 * Created by zhangxingcai on 2016/4/22 0022.
 */
define(function (require, exports, module) {
    var internal = {
        selectList: require("{dir}/UtilityModule/SelectList/list"),
        init: function () {
            var BaseAttr = require("{staticDir}/BaseAttr/baseAttr");
            var oidCodeConfig = require("{dir}/JsConfig/oidCodeConfig").oidCodeConfig;
            var baseAttr = new BaseAttr({
                winName: "win_medicalStaff_detail_dialog",//弹窗对象变量名称
                winCallback: "win_medicalStaff_detail_callback",//弹窗回调函数
                getUrl: 'personnel/getMedStfInfo',//
                addUrl: 'personnel/addMedStaffInfo',//新增接口Url
                updateUrl: 'personnel/updateMedStfInfo',//修改接口Url
                loadPageEvent: function () {
                    $("#selSex").select({
                        name: 'genderCode',
                        display: 'genderName',
                        ajaxParam: {
                            url: 'organization/getMedicalOrgCategoryList',//url 请求的地址
                            data: {codeSystem: oidCodeConfig.sex},
                        },
                        value: 'code',//值
                        text: 'name'//展示的内容
                    });
                    internal.selectList.dialog('medicalOrg', {
                        target: $("#btnFkOrganization"),
                        name: 'affiliatedOrgCode',//绑定value值
                        parentName: 'affiliatedOrgName',//绑定name值
                        displayField: 'name',
                        valueField: 'code',
                        isAllowEmptySelect: true,
                        selectParam: {
                            multiselect: false,
                            param: {type: 0},
                            storage: function () {
                                var data = [];
                                var affiliatedOrgCode = common.getParamFromUrl("deptCode");
                                var affiliatedOrgName = common.getParamFromUrl("deptName");
                                if (affiliatedOrgCode && affiliatedOrgCode != "null") {
                                    var info = {
                                        affiliatedOrgCode: affiliatedOrgCode,
                                        affiliatedOrgName: decodeURIComponent(affiliatedOrgName)
                                    };
                                    data.push(info);
                                }
                                return data;
                            }()
                        }
                    })

                    internal.selectList.dialog('medicalDept', {
                        target: $('#btnFkAssignedDept'),
                        name: 'assignedDeptCode',
                        parentName: 'assignedDeptName',
                        displayField: 'name',
                        valueField: 'code',
                        isAllowEmptySelect: true,
                        selectParam: {
                            multiselect: false,
                            param: function () {
                                var param = {
                                    type: 0,
                                    deptParentCode: $("[name='affiliatedOrgCode']").val()
                                }
                                return param;
                            }
                        }
                    });
                    internal.selectList.dialog('dictItem', {
                        target: $('#btnFkTechnical'),
                        name: 'technicalCode',
                        parentName: 'technicalName',
                        displayField: 'name',
                        valueField: 'code',
                        isAllowEmptySelect: true,
                        selectParam: {
                            multiselect: false,
                            param: {codeSystem: oidCodeConfig.duty}
                        }
                    });


                }
            })
        }
    }
    exports.init = function () {
        internal.init();
    }
});