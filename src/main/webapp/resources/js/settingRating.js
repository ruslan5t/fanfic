
$(function() {
	var $rating = $(".rating");
	var contextPath = $("#contextPath").attr("value");
	var baseRatyOptions = {
		path: contextPath + "/resources/js/img/"
	};
	if ($("#isLogged").attr("value") === "true") {
		$rating.each(function() {
			var rating = $(this).attr("rating");
			$(this).raty($.extend({
				click: setUsersRating,
				score: rating
			}, baseRatyOptions));
		});
	}
	else {
		$rating.each(function() {
			var rating = $(this).attr("rating");
			$(this).raty($.extend({
				readOnly: true,
				score: rating
			}, baseRatyOptions));
		});
	}

	function setUsersRating(rating) {
		var $ratingElement = $(this);
		$.ajax({
			url: contextPath + "/setFanficRating/" 
				+ $ratingElement.attr("fanficId") + "/" + rating,
			type: "post",
			success: function(fanficRating) {
				setFanficRating(fanficRating, $ratingElement);
			}
		});
	}

	function setFanficRating(fanficRating, $ratingElement) {
		$ratingElement.raty("score", fanficRating);
	}
});