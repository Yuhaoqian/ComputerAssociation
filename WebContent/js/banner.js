//$(function () {
////	$.getJSON(
////		'bannerServlet',
////		'',
////		function(result){
////			$('.banner>li').each(function(index,element){
////				$(element).css('backgroundImage','url(img/intro-carousel/'+result[index].img+')');
////				console.log(result[index].img);
////			});
////	});
//    let count=0;
//    function bannerAnimate() {
//    	$('.banner>li').fadeOut(500);
//        $('.banner>li').eq(count).fadeIn(500);
//    }
//    function changeStyleOfDot() {
//        $('.dot-container>ul>li>a').eq(count).addClass('aHover').parent().siblings().children('a').removeClass('aHover');
//    }
//    function setInterval() {
//        return window.setInterval(function () {
//            count++;
//            count %= 6;
//            bannerAnimate();
//            changeStyleOfDot();
//        }, 5000);
//
//    }
//    function clickDotClearStyle(){
//        window.clearInterval(timeId);
//        count %= 6;
//        bannerAnimate();
//        changeStyleOfDot();
//        timeId = setInterval();
//    }
//    let timeId = setInterval();
//    $('.right-arrow').on('click',function () {
//        count++;
//        clickDotClearStyle();
//    });
//    $('.left-arrow').on('click',function () {
//        count--;
//        clickDotClearStyle();
//    });
//    $('.dot-container>ul>li>a').each(function (index, element) {
//        $(this).on('mouseenter',function () {
//            count = index;
//            bannerAnimate();
//            changeStyleOfDot();
//        });
//    });
//
//});