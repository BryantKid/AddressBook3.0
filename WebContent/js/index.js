$.ajaxSetup({ 
    scriptCharset: "utf-8",
    contentType: "application/json; charset=utf-8"
});

$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "contacts/findAllContacts",
        dataType : 'json',
		success : function(data) {

			$("#informationTable").html('');
			$("#informationTable").html('<tr><td align="center">姓名</td><td align="center">电话</td><td align="center">操作</td></tr>');
			$(data.list).each(function(i, value) {
				$("#informationTable").append('<tr><td>'+ value.name
								+'</td><td align="center">'+value.phone+'</td><td align="center">'+
								'<input type="button" style="float:right" value="删除" class="btn btn-primary"'+
								' onclick="deleteContacts('+value.id+',this)"></td><tr>');});			
		},
    });
});

function searchContacts(key) {
	$.ajax({
				type : "GET",
				url : "contacts/searchContacts?key=" + $("#search").val(),
				dataType : 'json',
				success : function(data) {
					console.log('searchContacts success.');
					$("#informationTable").html('');
					$("#informationTable").html('<tr><td align="center">姓名</td><td align="center">电话</td><td align="center">操作</td></tr>');
					$(data.list).each(function(i, value) {
						$("#informationTable").html($("#informationTable").html()
						+'<tr><td>'+ value.name+'</td><td align="center">'+value.phone+'</td><td align="center">'+
						'<input type="button" style="float:right" value="Delete" class="btn btn-primary"'+
						' onclick="deleteContacts('+value.id+',this)"></td><tr>');});			
				},
		    });
		};
		
function deleteContacts(id,obj){
	$.ajax({
		type : "GET",
		url : "contacts/deleteContacts?id=" + id,
		dataType : 'json',
		success : function() {
			var node= obj.parentNode.parentNode;
			node.parentNode.removeChild(node);
		},
    });
};

function addContacts(){

	var name = $("#name").val();
	var phone = $("#phoneNum").val();

	
	$.ajax({
		type : "GET",
		url : "contacts/addContacts",
		data : {
			name:name,
			phone:phone,
        },
        contentType:"charset=UTF-8",
		success : function() {
			
			location.href="index.jsp";
		},
    });
};


