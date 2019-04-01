
jQuery(document).ready(function(){
     postData(1,12,"全体","全体");
});


function changePage(ob) {
    var str = $(ob).attr("id");
    var num = str.charAt(str.length-1);
    var grade = $("#gradeSelected").val();
    var major = $("#majorSelected").val();
    postData(num,12,grade,major);
}

function jumpPage(ob) {
    var str = $(ob).attr("id");
    var grade = $("#gradeSelected").val();
    var major = $("#majorSelected").val();
    var num = 0;
    var beginPage = 0;
    var click = window.location.href.split("#");
    if(click.length>1){
        var beginPage = parseInt(click[1]);
    }else{
        beginPage = 1
    }

    if(str == "last_page"){
       num = beginPage -1;
    }
    else{
        num = beginPage +1;
    }
    $(ob).attr("href","#"+num);
    postData(num,12,grade,major);
}

$("#searchByconidition").on("click",function () {
   var grade = $("#gradeSelected").val();
   var major = $("#majorSelected").val();
   var str = window.location.href.split("#");
   var num = 0;
   if(str.length>1){
       num = parseInt(str[1]);
   }
   else{
       num = 1;
   }
   postData(num,12,grade,major);
});

function postData(num,pageSize,grade,major){
    //获取basePath，测试的话就能用就完了
    var obj = window.document.location;
    var BASE_PATH = obj.href.substring(0, obj.href.indexOf(obj.pathname));
    if(grade == "请选择"){
        grade = "全体";
    }
    if(major == "请选择"){
        major = "全体";
    }
    $.ajax({
        url: BASE_PATH + "/user/selectByGrade",
        type: "post",
        dateType: "json",
        data: {"pageNum":num,"pageSize":12,"grade":grade,"major":major},
        async: false,
        success: function f(data) {
            for(var i = 0 ;i<data.list.length;i++){
                $("#num_"+(i+1)).text((num-1)*12+(i+1));
                $("#name_"+(i+1)).text(data.list[i].userName);
                $("#grade_"+(i+1)).text(data.list[i].userGrade);
                $("#room_"+(i+1)).text(data.list[i].userMajor);
            }
        },
        error: function f(data) {
            alert("lose");
        }
    });
}
