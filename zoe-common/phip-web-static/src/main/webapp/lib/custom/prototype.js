﻿

//向前推N周，考虑跨年周，返回结果数组：
//结果：[0,1]   索引0所在的值为当前周所在的日期；索引1所在的值为当前周所在年份的的几周
//参数num为往前推几周
//参数type：0代表返回周的第一天，1代表返回周的最后一天
Date.prototype.weekBefore = function (num, type) {

}

//截取长度
String.prototype.cut = function (strLength, cutLenght) {
    if (this.length > strLength) {
        return this.substring(0, cutLenght) + "...";
    } else {
        return this;
    }
};



