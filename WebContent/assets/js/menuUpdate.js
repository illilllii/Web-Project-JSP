var file = document.querySelector('#menu-file-input');

file.onchange = function () { 
    var fileList = file.files ;
    var reader = new FileReader();
    reader.readAsDataURL(fileList [0]);

    reader.onload = function  () {
        document.querySelector('#detail-image').src = reader.result ;
    }; 
};

function updateMenu(id, oldImageSrc) {
	var fakePath = file.value;
	var fileName = fakePath.split('\\');
	var imageSrc;
	var pageData = $("#menuAdmin-detail").data().menu;
	$('input:radio[name="kind"]').each(function(i) {
		if ($(this).is(":checked") == true) {
			filePath = "/ediya/assets/img/menu/";
			filePath += pageData + "/";
			filePath += $(this).data().kind + "/";
			filePath += fileName[2];
		}

	});

	if(!fakePath) {
		imageSrc = oldImageSrc;
	} else {
		imageSrc = filePath;
	}

	var name = $("#detail-name").val();
	var subname;
	var content = $("textarea#detail-content").val();
	var kind;
	var recommend = $("input[name='recommend']:checked").val();

	var data;
	
	if(pageData != 'md') {
		subname = $("#detail-subname").val();
		kind = $("input[name='kind']:checked").val();
		data = {
				"id" : id,
				"name" : name,
				"subname" : subname,
				"imageSrc" : imageSrc,
				"content" : content,
				"kind" : kind,
				"recommend" : recommend
			};
	} else {
		data = {
				"id" : id,
				"name" : name,
				"imageSrc" : imageSrc,
				"content" : content,
				"recommend" : recommend
			};
	}
	$.ajax({
		type: "post",
		url: "/ediya/admin?cmd="+pageData+"Update",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json"
		
	}).done(function(result) {
		if(result.statusCode == 1) {
			console.log(result);
			alert("수정 성공");
			location.replace("/ediya/admin?cmd=menuList");
			
		}
	});
}