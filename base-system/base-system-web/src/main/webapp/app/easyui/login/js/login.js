function loginAction(){
	var username = $('#username').val();
	var password = $('#password').val();
    var rememberMe = $('#rememberMe').val();
	
	if(username.length==0 || password.length == 0){
		$("#msg").css('display','block'); 
		$('#msg').html('请输入用户名和密码');
		return ;
	}
	var params = {username:username,password:password,rememberMe:rememberMe};
	
	$.post(basePath+"/system/user/login.json",params,function(data,status){
		if(data.code == 10000){
			window.location.href=basePath+"/system/home/index.html";
		}else{
			//alert('提示',data.desc);	
			$("#msg").css('display','block'); 
			$('#msg').html(data.desc);
		}
	});
}

document.onkeydown = function(event) {
    var theEvent = window.event || event;
    var code = theEvent.keyCode || theEvent.which;
    if (code === 13) {
        $("#loginBtn").click();
    }
};