
$(document).ready(function(){
    $("#submit").click(function(){
    	console.log(document.getElementById('userid').value);
    	console.log(document.getElementById('password').value);
        $.ajax({
        	url : 'User',
        	type:"post",
        	data : {
        		create : "login",
        		email : document.getElementById('userid').value,
        		password:document.getElementById('password').value,
			},
			dataType: 'text',
        	success: function(result){
        		if(result==="Invalid Password" | result==="Invalid Emailid"){
        			console.log(result);
        			$("#error").text(result);
        		}else
        			location.href = "home.jsp"
        		
        },
        error : function (jqXHR, status, err) {
            alert("Local error callback.");
            console.log(err);
          } 
			
        });
        
    });
});