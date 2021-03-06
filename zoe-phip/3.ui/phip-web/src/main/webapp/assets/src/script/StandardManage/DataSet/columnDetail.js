/**
 * Created by chenzhisen on 2016/5/6.
 */
define(function (require, exports, module) {
    var internal = {
        selectList: require("{dir}/UtilityModule/SelectList/list"),
        init: function () {

            var fkSetId = common.getParamFromUrl("fkSetId");
            $("#fkSetId").val(fkSetId);

            var BaseAttr = require("{staticDir}/BaseAttr/baseAttr");
            var baseAttr = new BaseAttr({
                winName: "win_ele_detail_dialog",//弹窗对象变量名称
                winCallback: "win_ele_detail_callback",//弹窗回调函数
                getUrl: 'dataSet/getRsSetColumnById',//
                addUrl: 'dataSet/addRsSetColumn',//新增接口Url
                updateUrl: 'dataSet/updateRsSetColumn',//修改接口Url
                loadPageEvent: function () {
                    $("#isIndexKey").btnSwitch({name: 'isIndexKey'});
                    $("#isPrimaryKey").btnSwitch({name: 'isPrimaryKey'});
                    $("#isNullable").btnSwitch({name: 'isNullable'});
                    internal.selectList.dialog('dataElement', {
                        target: $("#btnDataElement"),
                        name: 'fkElementId',
                        parentName: 'baseElementName',
                        valueField: 'id',
                        displayField: 'name',
                        fkNullContent: '无',
                        selectParam: {
                            isTreeVaild: true,//如果是树节点，父节点不能是其本身验证
                            treeVaildMsg: '父级分类不能是其本身!',
                            multiselect: false
                        }
                    });
                    internal.selectList.dialog('dict', {
                        target: $("#btnDict"),
                        name: 'fkDictId',
                        parentName: 'dictName',
                        valueField: 'id',
                        displayField: 'name',
                        fkNullContent: '无',
                        selectParam: {
                            isTreeVaild: true,//如果是树节点，父节点不能是其本身验证
                            treeVaildMsg: '父级分类不能是其本身!',
                            multiselect: false
                        }
                    });
                },
                beforeSaveEvent: function () {
                    var type = $("#dataType").val();
                    var length = $("#dataLength").val()

                    switch (type) {
                        case "":
                        case "BLOB":
                        case "DATE":
                        case "CLOB":

                            return true;
                    }
                    var check = dataTypeVerify[type.toUpperCase()](length);
                    if (check) {
                        $("#vaildDataLength").show().removeClass("Validform_wrong");
                        $("#dataLength").removeClass("Validform_error");
                    } else {
                        $("#vaildDataLength").show().addClass("Validform_wrong");
                        $("#dataLength").addClass("Validform_error");
                    }
                    return check;
                },
                beforeBindEvent:function(data){
                 internal.showLength(data.dataType);
                }
            })
            internal.event();


        },
        event: function () {
            $("#dataType").change(function () {
                $("#vaildDataLength").hide().removeClass("Validform_wrong");
                $("#show_dataLength").hide();
                $("#show_dataAccuracy").hide();
                $("#dataLength").val("");
                $("#dataAccuracy").val("");
                var type = $("#dataType").val();
                internal.showLength(type);
            });
            $("#dataLength").unbind();
            $("#dataLength").focus(function () {
                var msg = $(this).attr("msg");
                if ($(this).hasClass("Validform_error")) {
                    var postion = $(this).offset();
                    var left = postion.left, top = postion.top;
                    $(".text-up-tips").css({
                        left: left,
                        top: top - 26,
                        "z-index": 999
                    }).show().find(".msg").text(msg);
                }
            });
            $("#dataLength").blur(function () {
                $(".text-up-tips").hide();
                var type = $("#dataType").val();
                var length = $("#dataLength").val()
                var check = dataTypeVerify[type.toUpperCase()](length);
                if (!check) {
                    $("#vaildDataLength").show().addClass("Validform_wrong");
                    $(this).addClass("Validform_error");
                } else {
                    $("#vaildDataLength").show().removeClass("Validform_wrong");
                    $(this).removeClass("Validform_error");
                }
            })
        },
        showLength:function(type){

            switch (type) {
                case "CHAR":
                case "NVARCHAR2":
                    $("#dataLength").attr("msg", "数据长度1-2000");
                    $("#show_dataLength").show();
                    break;
                case "VARCHAR2":
                    $("#dataLength").attr("msg", "数据长度1-4000");
                    $("#show_dataLength").show();
                    break;


                case "NUMBER":
                    $("#dataLength").attr("msg", "数据长度1-38");
                    $("#show_dataLength").show();
                    $("#show_dataAccuracy").show();
                    break;
            }
        }
    }

    var dataTypeVerify = {
        'CHAR': function (length) {
            if (!length || length > 2000) {
                return false;
            }
            return true;
        },
        'VARCHAR2': function (length) {
            if (!length || length > 4000) {
                return false;
            }
            return true;
        },
        'NVARCHAR2': function (length) {
            if (!length || length > 2000) {
                return false;
            }
            return true;
        },
        'NUMBER': function (length) {
            if (!length || length > 38) {
                return false;
            }
            return true;
        }
    };

    exports.init = function () {
        internal.init();
    }
});