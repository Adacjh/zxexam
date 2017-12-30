/*
 **************************
 author:Keel (keel.sike@gmail.com)
 **************************

 页码显示jquery插件,只需要存在#pageNav,则会在其中显示页码.
 调用时可根据需要先重写go方法.(已去除jquery依赖)

 **************************
 示例(注意：页面中放置id为pageNav的html对象):

 //转到页码时触发的自定义方法,p为当前页码,pn为总页数
 pageNav.fn = function(p,pn){
 alert(p+","+pn);
 };
 //初始跳到第3页,共33页
 pageNav.go(3,33);

 */
var pageNav = pageNav || {};
pageNav.fn = null;
//p为当前页码,pn为总页数
pageNav.nav = function(p, pn) {
    //只有一页,直接显示1
    if (pn <= 1) {
        this.p = 1;
        this.pn = 1;
        return this.pHtml2(1);
    }
    if (pn < p) {
        p = pn;
    };
    var re = "";
    //第一页
    if (p <= 1) {
        p = 1;
    } else {
        //非第一页
        var j=parseInt(p)
      // alert(j);
        re += this.pHtml(j-1, pn, "&laquo;");
        //总是显示第一页页码
        re += this.pHtml(1, pn, "1");
    }
    //校正页码
    this.p = p;
    this.pn = pn;

    //开始页码
    var start = 2;
    var end = (pn < 6) ? pn: 6;
    //是否显示前置省略号,即大于10的开始页码
    if (p >= 5) {
        re += "<span class='mor'></span>";
        var j=parseInt(p)
        start = j - 2;
        var e = j + 2;
        end = (pn < e) ? pn: e;
    }
    for (var i = start; i < p; i++) {
        re += this.pHtml(i, pn);
    };
    re += this.pHtml2(p);
    var j=parseInt(p)
    for (var i = j + 1; i <= end; i++) {
        re += this.pHtml(i, pn);
    };
    if (end < pn) {
        re += "<span class='mor'></span>";
        //显示最后一页页码,如不需要则去掉下面这一句
        re += this.pHtml(pn, pn);
    };
    if (p < pn) {
        var j=parseInt(p)
        re += this.pHtml(j + 1, pn, "&raquo;");
    };
    return re;
};
//显示非当前页
pageNav.pHtml = function(pageNo, pn, showPageNo) {
    showPageNo = showPageNo || pageNo;
    var H = " <a onclick=start("+pageNo+") href='javascript:pageNav.go(" + pageNo + "," + pn +",true);' class='pageNum'>" + showPageNo + "</a> ";
    return H;

};
//显示当前页
pageNav.pHtml2 = function(pageNo) {
    var H = " <strong><a href='#' id='pageId'>" + pageNo + "</a> </strong>";
    return H;
};
/*pageNav.go = function(p, pn, ifGo) {
	$("#pageNav").html(this.nav(p,pn));
	//document.getElementById("pageNav").innerHTML = this.nav(p, pn);
*/	
/*	if (ifGo) {
	
		
	}*/
/*}*/