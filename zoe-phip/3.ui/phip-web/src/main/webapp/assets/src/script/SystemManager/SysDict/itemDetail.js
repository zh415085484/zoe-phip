/**
 * Created by linqinghuang on 2016/3/31.
 */
define(function (require, exports, module) {
    var internal = {
        init: function () {
            var BaseAttr = require("{staticDir}/BaseAttr/baseAttr");
            var baseAttr = new BaseAttr({
                dialogParam: {
                    otherUrlParam: ['fkSystemDictCategoryId']
                },
                winName: "win_dict_item_dialog",//弹窗对象变量名称
                winCallback: "win_dict_item_callback",//弹窗回调函数
                getUrl: 'dict/getSysDictItemInfo',//
                addUrl: 'dict/addItem',//新增接口Url
                updateUrl: 'dict/updateItem'//修改接口Url
            })
        }
    }
    exports.init = function () {
        internal.init();
    }
});