// JavaScript Document
         $(document).ready(function(){
			
				//幻灯片元素与类"menu_body"段与类"menu_head"时点击
				$("#firstpane .menu_body:eq(6)").show();
				$("#firstpane p.menu_head").click(function(){
					$(this).addClass("current").next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
					$(this).siblings().removeClass("current");
				});

			});