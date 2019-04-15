<#--<#import "/spring.ftl" as spring/>-->
<#--<html>-->
<#--<body>-->
<#--<h2>Hello World (ftl)!-->
<#--<@spring.message "welcome.springmvc"/>-->
<#--</h2>-->
<#--</body>-->
<#--</html>-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>跨域请求</title>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        $(document).ready(function(){
            $("button").click(function(){
                $.ajax(
                    {
                        url:"http://mscreen.jd.id/address/findByAddressId",
                        type:"post",
                        data:{
                            "addressId":"001"
                        },
                    success:function(result){
                        alert(result);
                    }});
            });
        });
    </script>
</head>
<body>

<p width="500px" height="100px" id="p1"></p>
<button>获取其他内容</button>
</body>
</html>
