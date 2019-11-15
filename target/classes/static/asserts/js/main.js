$(function(){
    getSeats(); //获取一百个位置的状态并显示
});
var current = -1;
function getSeats(){
    $.ajax({
        url:"/getSeats",
        type:"GET",
        success:function(result){
            var count = ["one","two","three","four","five","six","seven","eight","nine","ten"];
            content = $(".content > ."+count[0]);
            result = JSON.parse(result);
            for(var i = 0; i < 100; i++){
                // console.log(result[i]);
                if(i % 10 == 0){    //需换行
                    content = $(".content > ."+count[i/10])
                }
                if(result[i] == true){          //被占用
                    (function (j) {
                        $("<div></div>").addClass("col-xs-1").addClass("seat").css("backgroundColor","red").appendTo(content).click(function () {
                            // alert(j);
                            var modalContent = $("#myModal .modal-body p");
                            modalContent.text("This seat was seated! Please land another one instead.");
                            $(".modal-footer").hide();
                            $("#myModal").modal();
                        })
                    })(i);
                }else{
                    (function (j) {
                        $("<div></div>").addClass("col-xs-1").addClass("seat").css("backgroundColor","green").appendTo(content).click(function(){
                            // alert(j);
                            var modalContent = $("#myModal .modal-body p");
                            modalContent.text("You have selected number "+ j + " seat, are you sure?");
                            current = j; //设置当前位置
                            $(".modal-footer").show();
                            $("#myModal").modal();
                        })
                    })(i+1);
                }
            }

        }
    })
}

$("#submit").click(function () {
    $.ajax({
        url:"/submit",
        type:"POST",
        data:{
            "current":current.toString()
        },
        success:function(result){
            alert(result);
            location.reload();
            // console.log(result);
        }
    })
});