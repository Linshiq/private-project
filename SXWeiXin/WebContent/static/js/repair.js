    /* 如果其中有一个函数出错了，这个JS文件就不能被引用了。*/
    
    //当前时间 
    function today(){
        var mydate = new Date();
        var weekday=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
        var now="现在是："+mydate.getFullYear()+"年"+(mydate.getMonth()+1)+"月"+mydate.getDate()+"日  "+mydate.getHours()+":"+mydate.getMinutes()+" "+weekday[mydate.getDay()];
        document.getElementById("nowDiv").innerHTML = now;
    }
    //清空文本域的默认提示
    function clearText(field){
        if (field.defaultValue == field.value) field.value = '';
        else if (field.value =='') field.value = field.defaultValue;
    }
    //按钮数值变化以及按钮不可用
    function changeBtn(){
         var c=document.getElementById("btn_finish").value;
         c="已完成";
         document.getElementById("btn_finish").value=c;
         document.getElementById("btn_finish").disabled=true;
    }
    //考虑浏览器兼容的提示关闭本页面
    function wClose(){
        if (confirm("您确定要关闭本页吗？")){
            if (navigator.userAgent.indexOf("MSIE") > 0) {
                if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
                    window.opener = null;
                    window.close();
                } else {
                    window.open('', '_top');
                    window.top.close();
                    }
                }
                else if (navigator.userAgent.indexOf("Firefox") > 0) {
            window.location.href = 'about:blank ';
            } else {
            window.opener = null;
            window.open('', '_self', '');
            window.close();
            }
        }
        else{}
    }
    //考虑浏览器兼容的不提示关闭本页面
    function CloseWebPage(){
        if (navigator.userAgent.indexOf("MSIE") > 0) {
        if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
            window.opener = null;
            window.close();
        } else {
            window.open('', '_top');
            window.top.close();
        }
        }
        else if (navigator.userAgent.indexOf("Firefox") > 0) {
            window.location.href = 'about:blank ';
        } else {
            window.opener = null;
            window.open('', '_self', '');
            window.close();
        }
    }