// JavaScript Document
     $(function(){
	     $("#zi1_2_1").click(function(){
             $("#zi2").css("display","block");
			 $("#zi3").css("display","none");
			 $("#zi4").css("display","none");
	     });
	     $("#zi1_3_1").click(function(){
             $("#zi2").css("display","none");
			 $("#zi3").css("display","block");
			 $("#zi4").css("display","none");
	     });
	   	 $("#zi1_4_1").click(function(){
             $("#zi2").css("display","none");
			 $("#zi3").css("display","none");
			 $("#zi4").css("display","block");
         });
	   	 $("#zi1_5_1").click(function(){
			 $("#zi2").css("display","none");
			 $("#zi3").css("display","none");
			 $("#zi4").css("display","none");
	     });
	})
 $(function () {
    //�����¼�
        var collection = $(".zi1_2");
        $.each(collection, function () {
            $(this).addClass("start");
        });
        $("#zi1_2_1").removeClass("start");
		$("#zi1_2_1").addClass("end");
        });
    //�����¼�
      function dj(dom) {
        var collection = $(".zi1_2");
        $.each(collection, function () {
            $(this).removeClass("end");
            $(this).addClass("start");
        });
        $(dom).removeClass("start");
        $(dom).addClass("end");
    }

	