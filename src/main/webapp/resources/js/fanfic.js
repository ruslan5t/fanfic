
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
			url: $("#contextPath").attr("value") + "/setFanficRating/" 
				+ $("#fanficId").attr("value") + "/" + rating,
			type: "post",
			success: setFanficRating
		});
	}

	function setFanficRating(fanficRating) {
		console.log(fanficRating);
		$("#rating").raty("score", fanficRating);
	}
	
	$("#convertToPdf").on("click", convertFanficToPdf);
	
	function convertFanficToPdf() {
		$.ajax({
			url: $("#contextPath").attr("value") + "/convertFanficToPdf/" 
				+ $("#fanficId").attr("value"),
			type: "post",
			success: setHrefToConvertedFile 
		});
	}
	
	function setHrefToConvertedFile(hrefToConvertedFile) {
		$("#hrefToConvertedFile").attr("href", hrefToConvertedFile);
		$("#hrefToConvertedFile").text("Download");
	}
});