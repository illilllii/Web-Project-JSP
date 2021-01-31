var file = document.querySelector('#menu-file-input');
var reader = new FileReader();
file.onchange = function() {
	var fileList = file.files;

	reader.readAsDataURL(fileList[0]);

	reader.onload = function() {
		document.querySelector('#insert-image').src = reader.result;
	};
};

function insertMenu() {
	var pageData = $("#menuAdmin-insert").data().menu;
	var name = $('#insert-name').val();
	var imageSrc = reader.result;
	var recommend = $("input[name='recommend']:checked").val();
	var content = $("textarea#insert-content").val();
	var data;

	if (pageData != 'md') {
		var subname = $("#insert-subname").val();
		var kind = $("input[name='kind']:checked").val();
		data = {
			"name": name,
			"subname": subname,
			"imageSrc": imageSrc,
			"content": content,
			"kind": kind,
			"recommend": recommend
		};
	} else {
		data = {
			"name": name,
			"imageSrc": imageSrc,
			"content": content,
			"recommend": recommend
		};
	}
	$.ajax({
		type: "post",
		url: "/ediya/admin?cmd=" + pageData + "Insert",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(result) {
		if (result.statusCode == 1) {
			console.log(result);
			alert("등록 성공");
			location.replace("/ediya/admin?cmd=menuList");

		}
	});

}