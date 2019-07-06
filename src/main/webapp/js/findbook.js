/*$(function(){
 $("#input_1").click(function() {
            $.ajax({
                url : "/byserch",
                type : "POST",
                dataType:"json",
                 contentType : "application/json;charset=UTF-8",  
	          	 data : JSON.stringify({
                    id : $("#tablename").val(),
                 }),
                  success:function(result) {  
                     var message= JSON.stringify(result);
                     $("#select-box").html("查询成功" + message);
                 },
                error:function(result){
                     $("#select-box").html("查询失败");
                 }
             });
         });
 });*/