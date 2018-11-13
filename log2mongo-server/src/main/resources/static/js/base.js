var serverPath = '';

function rsaEncrypt(text) {
    // 创建加密对象
    var encrypt = new JSEncrypt();
    // 设置公钥
    encrypt.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPhuLKVwg6iyzpwRzkQPDPa3z5w/qwr2S5Nb7TczJZK7pRF5r+Va4h3EKxSn+jBpbmufvJgbpBr4uuJ8U0sPSx3GqoyIUiovbB7SLTKNRxMCfT+O3Qa+cKTqM3269ol8iW6QcmLXwM0nIwy0gLLWqUSPLjnAWJTJsIHDVEYW3rQQIDAQAB");
    // 加密
    return encrypt.encrypt(text);
}


/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * 例子：
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 * @author Yuanwl
 * @date 2018-11-10 10:28:21
 * @version v1.0.0
 */
Date.prototype.Format = function(fmt)
{ //author: meizz
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}