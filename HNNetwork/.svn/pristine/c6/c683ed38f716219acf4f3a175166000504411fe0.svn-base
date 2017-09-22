$(document).ready(function () {
    // 遮罩
    $("body").append("<div id='overlay_boxL' style='position:absolute;z-index:999;width:100%;height:100%;left:0;top:0;display:none;'></div>");
    var overlay = $("#overlay_boxL");

    $("div.popupLayerL").each(function (index) {
        var obj = $(this);
        //        alert(index);
        var clickBtnL = $(".yulan" + (index + 1));
        var closeBtnL = $(".closed" + (index + 1));
        //var deterBtnL = $("#deterh" + (index + 1));
        clickBtnL.click(function () {

            overlay.css({ height: $(document).height() }).show();
            obj.css({ opacity: 0.3, top: $(window).scrollTop() + $(window).height() }).css("z-index", "9999").show().animate({
                left: ($(document).width() - obj.width()) / 2,
                top: (document.documentElement.clientHeight - obj.height()) / 2 + $(document).scrollTop(),
                opacity: 0.8
            }, 500, function () { obj.css("opacity", 1) });
            show_log();
        });
        closeBtnL.click(function () {
            obj.animate({
                left: 61,
                top: 1742,
                opacity: 0.1
            }, { duration: 500, complete: function () { obj.css("opacity", 1); obj.hide(); overlay.hide(); } });
        });
    });
});

function closeShow() {
    var overlay = $("#overlay_boxL");
    var obj = $(".popupLayerL");
    obj.animate({
        left: 61,
        top: 1742,
        opacity: 0.1
    }, { duration: 500, complete: function () { obj.css("opacity", 1); obj.hide(); overlay.hide(); } });
}