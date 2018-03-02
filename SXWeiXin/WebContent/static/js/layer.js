function show_popup_msg(content, flag, time){
    var  style = '';
    if(flag == 1){
         style = 'background: #50C24E;';
    }else if(flag == 2){
         style = 'background: #d43f3a;';
    }

    if(!time){
        time = 1;
    }

    layer.open({
        content: content,
        class:"success",
        style: style,
        shade: false,
        time: time
    });
}

function alert_show(content, callFunc){
    layer.open({
        content: content,
        btn: ['确认', '取消'],
        shade: true,
        yes: function(){
            callFunc();
            window.location.reload();
        },
        no: function(){
        }
    });
}

function alert_button(content){
    layer.open({
        // title: title,
        content: content,
        btn: ['确认']
    });
}

function alert_msg(title,content){
    layer.open({
        title: title,
        content: content,
        btn: ['确认']
    });
}