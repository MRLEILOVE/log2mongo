layui.use(["element", "layer"], function() {
  var $ = layui.jquery,
    element = layui.element,
    layer = layui.layer;
  $(function() {
    var l_o = $(".left-menu"),
      tab = "top-tab",
      l_m = "left-menu",
      t_m = "top-menu";
    var mainHeight = $(window).height() - 60;
    l_o.on("click", "li", function() {
      $(this)
        .siblings()
        .removeClass("layui-nav-itemed");
    });

    $(".menu-flexible").click(function() {
      $(".left-menu-all").toggle();
      $(".layui-body,.layui-footer").css(
        "left",
        $(".left-menu-all").is(":hidden") ? "0" : "200px"
      );
    });
    // 本地存储
    l_o.find("a[data-id]").click(function() {
      if (typeof Storage !== "undefined") {
        sessionStorage.navDataId = $(this).attr("data-id");
      }
    });

    // 判断是否有本地存储
    // if (sessionStorage .getItem('dataId')) {
    //
    //     var getNowId = l_o.find("a[data-id=" + dataId + "]")
    //     var getNowParent = $(getNowId).parent()
    //     $(getNowParent).addClass('layui-this')
    //     console.log($(getNowParent)[0]);
    //     // 判断是否需要展开
    //     if ($(getNowParent)[0].tagName == 'DD') {
    //         $(getNowId).parents('.layui-nav-item').addClass('layui-nav-itemed');
    //     }
    // }

    // 判断是否支持本地存储
    // if (typeof Storage !== "undefined") {
    //   // 判断是否是第一次进入
    //   if (!sessionStorage.navDataId) {
    //     l_o.find("a[data-id='1']").click();
    //   } else {
    //     var navDataId = sessionStorage.getItem("navDataId");
    //     var getNowEl = l_o.find("a[data-id=" + navDataId + "]");
    //     var getNowParentEl = $(getNowEl).parent();
    //     console.log(getNowParentEl);
    //     $(getNowParentEl).addClass("layui-this");
    //     if (navCheckOpen(getNowEl)) {
    //       $(getNowEl)
    //         .parents(".layui-nav-item")
    //         .addClass("layui-nav-itemed");
    //     }
    //   }
    // } else {
    //   layer.msg("抱歉！您的浏览器不支持 Web Storage ...", { time: 1000 });
    // }

    // 判断是否需要张开
    // function navCheckOpen(el) {
    //   return el.closest(".layui-nav-child").hasClass("layui-nav-child")
    //     ? true
    //     : false;
    // }

    // 目录
    $(document).on("click", ".mulu,.masked", function() {
      $("body").toggleClass("mulu-hide");
    });

    document.body.addEventListener("touchstart", function() {});
   // FastClick.attach(document.body);

    // 搜索
    $(document).on("click", "#search-btn", function() {
      $(".search-res-mask").show();
      $(this)
        .parent()
        .siblings(".search-fix")
        .addClass("cur");
    });

    $(document).on("click", "#search-close", function() {
      $(".search-res-mask").hide();
      $(this)
        .parents(".search-fix")
        .removeClass("cur");
    });

    $(document).on("click", ".search-res-mask", function() {
      $("#search-close").trigger("click");
    });

    // 移动端下拉
    $(document).on("click", ".layui-table .layui-table-first", function() {
      if ($(window).width() > 992) {
        return;
      }
      if ($(this).hasClass("cur")) {
        $(this)
          .siblings()
          .hide();
        $(this).removeClass("cur");
      } else {
        $($(this).siblings()).css("display", "-webkit-box");
        $(this).addClass("cur");
      }
    });
  });
});
