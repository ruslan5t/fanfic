
$(function() {
	var baseRatyOptions = {
		path: $("#contextPath").attr("value") + "/resources/js/img/",
		score: $("#fanficRating").attr("value")
	};
	if ($("#isLogged").attr("value") === "true") {
		$("#rating").raty($.extend({
			click: setUsersRating
		}, baseRatyOptions));
	}
	else {
		$("#rating").raty($.extend({
			readOnly: true
		}, baseRatyOptions));
	}

	function setUsersRating(rating) {
		$.ajax({
			url: "/fanfic/setFanficRating/" + $("#fanficId").attr("value") +
			"/" + rating,
			type: "post",
			success: setFanficRating 
		});
	}

	function setFanficRating(fanficRating) {
		console.log(fanficRating);
		$("#rating").raty("score", fanficRating);
	}
});