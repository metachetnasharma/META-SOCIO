
alert("hi")
function followPeople(followingId,email){
	alert("hi")
	/*var followerId=Integer.parseInt(followerId);*/
	var followingId=followingId;
	var email=email;
	if (window.XMLHttpRequest) {
		
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var url = "FollowPeople?followingId="+followingId;
	req.open("GET", url, true);
	req.send();
	
	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status == 200) {
			
			var usersOfSameDepartment = JSON.parse(req.responseText);
		  
			var usersNameArray = [];
			var usersImageArray=[];
			var users_array = [];
			
			
			
			for(var i in usersOfSameDepartment) {
				
				
				if(usersOfSameDepartment.hasOwnProperty(i) && !isNaN(+i)) {
					alert("pooja"+usersOfSameDepartment[i].imageURL);
			    	alert(usersOfSameDepartment[i].name);
				  usersNameArray.push(usersOfSameDepartment[i].name);
			    	
				  usersImageArray.push(usersOfSameDepartment[i].imageURL);
			    }
			}
			
			var text="";
			 text+="<div class='about-content'>" +
 			   "<i class='fa fa-users fa-4x'></i>"+
 			   "<h3>Suggested People</h3>";
 			   
 			if(usersOfSameDepartment.length==1){
 			   text+="<div class='col-md-12 col-lg-2 col-sm-12 col-xs-12'>No Suggestions</div>";
 			 }
            else{
            	for (var i in usersOfSameDepartment) { 
    				alert("in for loop"+usersOfSameDepartment[i].name)
            		if( usersOfSameDepartment[i].emailId!=email){
            			alert("hi")
               // alert("pooja   "  +  usersOfSameDepartment[i].imageURL);
       			  text+="<div class='row' style='margin-bottom: 20px'>" +

     			   	"<div class='col-md-8'>"+usersOfSameDepartment[i].name+"</div>" +
     				"<div class='col-md-4'>"+
           			  
           				
     				
       				"<button class='btn btn-sm btn-outline-dark' onclick='followPeople("+usersOfSameDepartment[i].userId,email+")'>Follow</button>"+
       				
       				"</div>"+
       				"</div>";
        		}
				
        	}
            }	
           		
            text+="</div>";			
           	
        
				document.getElementById("result").innerHTML =text;
				alert(document.getElementById("result").innerHTML )
			
		}
}

}
	
	



function editPost(postId){
	
	alert("editpastby id")
	var postContent=document.getElementById(postId).value;
	$("#editContent").val(postContent);
	document.getElementById("postId").value=postId;
	$("#editForm").attr("hidden",false);
	
	alert("post"+document.getElementById("postId").value);
	
	$("#editForm").submit(updatePost);
	
}


function updatePost(){

	alert("edit")
	alert("kkkk"+document.getElementById("postId").value);
	alert($("#editContent").val());
	var postId = document.getElementById("postId").value;
	var postContent=$("#editContent").val();
	
	
	
	if (window.XMLHttpRequest) {
		
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var url = "EditPost?postId=" + postId+"&postContent="+postContent;
	req.open("GET", url, true);
	req.send();
	
	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status == 200) {
			
			var postDetails=req.req.responseText;
			document.getElementById("post"+postId).innerHTML=postDetails;
			}
		}	
	
	$("#editForm").attr("hidden",true);
}


function editComment(commentId){
	alert("editcommenttby id")
	var commentContent=document.getElementById("commentId"+commentId).value;
	$("#editContent").val(commentContent);
	document.getElementById("commentId").value=commentId;
	
	$("#editForm").attr("hidden",false);
	
	alert("comment"+document.getElementById("commentId").value);
	
	$("#editForm").submit(updateComment);
}



function updateComment(){

	alert("edit")
	alert("rrrrr"+document.getElementById("commentId").value);
	alert($("#editContent").val());
	var commentId = document.getElementById("commentId").value;
	var commentContent=$("#editContent").val();
	
	
	
	if (window.XMLHttpRequest) {
		
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var url = "EditComment?commentId=" + commentId+"&commentContent="+commentContent;
	req.open("GET", url, true);
	req.send();
	
	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status == 200) {
			
			var commentDetails=req.req.responseText;
			document.getElementById("comment"+commentId).innerHTML=commentDetails;
			}
		}	
	
	$("#editForm").attr("hidden",true);
}



