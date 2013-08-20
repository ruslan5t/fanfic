
$(function() {
	var $rating = $("#rating");
	var fanficId = $("#fanficId").attr("value");
	var contextPath = $("#contextPath").attr("value");
	var baseRatyOptions = {
		path: contextPath + "/resources/js/img/",
		score: $("#fanficRating").attr("value")
	};
	if ($("#isLogged").attr("value") === "true") {
		$rating.raty($.extend({
			click: setUsersRating
		}, baseRatyOptions));
	}
	else {
		$rating.raty($.extend({
			readOnly: true
		}, baseRatyOptions));
	}

	function setUsersRating(rating) {
		$.ajax({
			url: contextPath + "/setFanficRating/" 
				+ fanficId + "/" + rating,
			type: "post",
			success: setFanficRating
		});
	}

	function setFanficRating(fanficRating) {
		$rating.raty("score", fanficRating);
	}
	
	$("#convertToPdf").on("click", convertFanficToPdf);
	
	function convertFanficToPdf() {
		$.ajax({
			url: contextPath + "/convertFanficToPdf/" 
				+ fanficId,
			type: "post",
			success: setHrefToConvertedFile 
		});
	}
	
	function setHrefToConvertedFile(hrefToConvertedFile) {
		$("#hrefToConvertedFile").attr("href", hrefToConvertedFile);
		$("#hrefToConvertedFile").text("Download");
	}
});