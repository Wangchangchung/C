// JavaScript Document

//用于所有页面的js
var screen_width = screen.width;
var screen_height = screen.height;

jQuery(document).ready(function($) {	//导航栏点击后，滑动到特定功能块的js
	
	$(".scroll").click(function(event){
		event.preventDefault();
		$('html,body').animate({scrollTop:$(this.hash).offset().top},800);
	});
	
	$(".scroll_other").click(function(event){
		event.preventDefault();
		$('html,body').animate({scrollTop:$(this.hash).offset().top - 70},800);
	});
	

});

/*修正两个元素的某个属性property，使其一致，修正原型为example，被修正元素为be_fix，*/
function fix(example, be_fix, property){
	console.info('example ' + property + ' : ' + example.css(property));
	console.info('be_fix ' + property + ' : ' + be_fix.css(property));
	be_fix.css(property, example.css(property));
}