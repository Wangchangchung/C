/**
Demo script to handle the theme demo
**/
var Demo = function () {

    // Handle Theme Settings
    var handleTheme = function (path) {
        var panel = $('.theme-panel');
        // handle theme colors
        var setColor = function (color) {
        	//$.cookie("color", color);
        	$('#style_color').attr("href", path+"/assets/admin/layout2/css/themes/" + color + ".css");
            
        };

        $('.toggler', panel).click(function () {
            $('.toggler').hide();
            $('.toggler-close').show();
            $('.theme-panel > .theme-options').show();
        });

        $('.toggler-close', panel).click(function () {
            $('.toggler').show();
            $('.toggler-close').hide();
            $('.theme-panel > .theme-options').hide();
        });

        $('.theme-colors > ul > li', panel).click(function () {
            var color = $(this).attr("data-style");
            setColor(color);
            $('ul > li', panel).removeClass("current");
            $(this).addClass("current");
        });
    };

    return {
        init: function(path) {
        	//$('#style_color').attr("href", path+"/assets/admin/layout2/css/themes/default" + ".css");
            /*if($.cookie('color')==null){
            	$('#style_color').attr("href", path+"/assets/admin/layout2/css/themes/default" + ".css");
            }else{
            	$('#style_color').attr("href", path+"/assets/admin/layout2/css/themes/" + $.cookie('color') + ".css");
            }*/
            handleTheme(path);
            
        }
    };

}();