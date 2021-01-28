function addContent(data) {

		var contentItem = [];
		for (var i = 0; i < data.length; i++) {
			contentItem[i] = [ '' ];
			contentItem[i] += '<div class="menu-item">';
			contentItem[i] += '<img src= "'+data[i].imageSrc+'" />';
			contentItem[i] += '<div class="menu-item-title">' + data[i].name
					+ '</div>';
			contentItem[i] += '<div class="menu-content">';
			contentItem[i] += '<div class="menu-content__title d-flex justify-content-between">';
			contentItem[i] += '<div class="menu-content__title-left">';
			contentItem[i] += '<div class="menu-content__maintitle">'
					+ data[i].name + '</div>';
			contentItem[i] += '<div class="menu-content__subtitle">'
					+ data[i].subname + '</div>';
			contentItem[i] += '</div>';
			contentItem[i] += '</div>';
			contentItem[i] += '<hr />';
			contentItem[i] += '<div class="menu-content__content">'
					+ data[i].content + '</div>';
			contentItem[i] += '</div>';
			contentItem[i] += '</div>';

		}
		$("#menu-items").html(contentItem);

		$("#more-button").css("display", "block");
		$("#more-button").css("margin", "0 auto");
		$(".menu-item").slice(0, 4).show();
		$("#more-button").click(function(e) {
			e.preventDefault();
			$(".menu-item:hidden").slice(0, 4).show();
			if ($(".menu-item:hidden").length == 0) {
				$("#more-button").css("display", "none");
			}
		});

	}

	var keyword;
	
	var kindArray = [];
	var cmd = $("#menu-items").data().cmd;
	$('input:text[name="keyword"]').on(
			"propertychange change keyup paste input", function() {
				keyword = $('input:text[name="keyword"]').val();
				$('input:checkbox[name="kind"]').each(function(i) {
					if ($(this).is(":checked") == true) {
						kindArray.push($(this).val());
					}

				});
				console.log(keyword);

				var data = {
					"kind" : kindArray,
					"keyword" : keyword
				};

				$.ajax({
					type : "post",
					url : "/ediya/menu?cmd="+cmd,
					data : JSON.stringify(data),
					contentType : "application/json; charset=utf-8",
					dataType : "json"
				}).done(function(result) {
					if (result.statusCode == 1) {
						console.log(result.data);
						addContent(result.data)
					}

				}).fail(function() {
					alert("실패");
				});
			});
	$('input:checkbox[name="kind"]').click(function() {
		kindArray = [];
		
		$('input:checkbox[name="kind"]:checked').each(function(i) {

			if ($.inArray(this.value, kindArray) == -1) {
				kindArray.push(this.value);
			}

		});

		if(kindArray.length == 0 && (keyword == null || keyword == "")) {
			location.reload();
		}
		var data = {
			"kind" : kindArray,
			"keyword" : keyword
		};

		$.ajax({
			type : "post",
			url : "/ediya/menu?cmd="+cmd,
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function(result) {
			if (result.statusCode == 1) {
				console.log(data.kind.length);
				addContent(result.data);
			}

		}).fail(function() {
			alert("실패");
		});
		console.log(JSON.stringify(data));

	});