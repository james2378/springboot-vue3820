
var projectName = '旧物置换网站';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '旧物信息',
	url: './pages/jiuwuxinxi/list.html'
}, 

{
	name: '网站公告',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/springboota4365/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"卖家","menuJump":"列表","tableName":"maijia"}],"menu":"卖家管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"旧物类型","menuJump":"列表","tableName":"jiuwuleixing"}],"menu":"旧物类型管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"旧物信息","menuJump":"列表","tableName":"jiuwuxinxi"}],"menu":"旧物信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"置换交易","menuJump":"列表","tableName":"zhihuanjiaoyi"}],"menu":"置换交易管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"lunbotuguanli"},{"buttons":["新增","查看","修改","删除"],"menu":"网站公告","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看","查看评论","置换申请"],"menu":"旧物信息列表","menuJump":"列表","tableName":"jiuwuxinxi"}],"menu":"旧物信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看","查看评论","置换申请"],"menu":"旧物信息","menuJump":"列表","tableName":"jiuwuxinxi"}],"menu":"旧物信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"置换交易","menuJump":"列表","tableName":"zhihuanjiaoyi"}],"menu":"置换交易管理"}],"frontMenu":[{"child":[{"buttons":["查看","查看评论","置换申请"],"menu":"旧物信息列表","menuJump":"列表","tableName":"jiuwuxinxi"}],"menu":"旧物信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"旧物类型","menuJump":"列表","tableName":"jiuwuleixing"}],"menu":"旧物类型管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"旧物信息","menuJump":"列表","tableName":"jiuwuxinxi"}],"menu":"旧物信息管理"},{"child":[{"buttons":["查看","删除","审核"],"menu":"置换交易","menuJump":"列表","tableName":"zhihuanjiaoyi"}],"menu":"置换交易管理"}],"frontMenu":[{"child":[{"buttons":["查看","查看评论","置换申请"],"menu":"旧物信息列表","menuJump":"列表","tableName":"jiuwuxinxi"}],"menu":"旧物信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"卖家","tableName":"maijia"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
