$(function(){
			var count=0;
			$(".circle li").click(function(){
				count++;				
				if (count==$(".circle>ul>li").length) {
					count=0;
				}				
			})
			$(".circle li").each(function(count,element){
				$(element).click(function(){
					$(".ctLeft>ul>li").eq(count).fadeIn().siblings().fadeOut();
				})
			})
		});