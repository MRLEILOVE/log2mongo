/**
 * 把可共用的登录逻辑抽离到这里
 */

/**
 * 自动登录
 * 首先尝试获取登录页url后面的参数，如果存在tokenKey，就根据这个来尝试登录；
 * 如果失败了，再尝试拿保存在浏览器本地的token，如果存在，就根据这个来尝试登录；
 * 如果还是失败，才加载登录页面，让用户手动登录。
 */
function autoLogin() {
	var url;
	var tokenKey = $dou.getQueryValue('tokenKey');
	if(tokenKey) {
		url = 'common/users/aut/' + tokenKey;
	} else {
		var token = $dou.getToken();
		if(token) {
			url = 'common/users/loginCheck';
		}
	}
	if(url) {
		$dou.get({
			url: url,
			success: function(data) {
				loginSuccess(data);
			},
			error: function(meta) {
				loginFailure();
			}
		});
	}
}

/**
 * 登录成功后的操作
 * @param {用户对象} user
 */
function loginSuccess(user) {
	if(vm && vm.loaded != undefined) {
		vm.loaded = true;
	}
	
	saveOrUpdateUserInfo(user);

	switch(user.platform) {
		case $dou.platformType.OPERATION_PLATFORM:
			location.href = 'index.html?' + Math.random();
			break;

		case $dou.platformType.SUPPLIER_PLATFORM:
			location.href = 'index.html?' + Math.random();
			break;

		case $dou.platformType.AGENCY_PLATFORM:
			//审核中
			if(user.userAgency.reviewedResult == 0) {
				location.href = "待审核.html";
			}
			//审核通过
			else if(user.userAgency.reviewedResult == 1) {
				$dou.setToStorage("userType", user.type);
				location.href = 'index.html?' + Math.random();
			}
			//审核不通过
			else if(user.userAgency.reviewedResult == -1) {
				$dou.setToSessionStorage('_type', JSON.stringify(user.type))
				location.href = "审核不通过.html";
			}
			break;

		case $dou.platformType.WAP_PLATFORM:
			location.href = '个人中心.html?' + Math.random();
			break;
		default:
			break;
	}
}

/**
 * 保存或更新用户信息到本地浏览器，方便后续使用
 * @param {用户信息} user
 */
function saveOrUpdateUserInfo(user){
	$dou.setToken(user.token); // 保存token
	$dou.setToStorage($dou.UUKD_KEY, user.uukd); // 保存uukd

	$dou.setToStorage("userCode", user.code);
	$dou.setToStorage("userPhone", user.phone);
	$dou.setToStorage("userName", user.name);
}

/**
 * 登录失败后的操作
 */
function loginFailure() {
	$dou.removeToken(); // 清空 token 信息
	$dou.removeFromStorage($dou.UUKD_KEY); // 删除uukd
}