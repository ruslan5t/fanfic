
$ ->
	$rating = $(".rating")
	contextPath = $("#contextPath").attr("value")
	baseRatyOptions = {
		path: contextPath + "/resources/js/img/"
	}
	setFanficRating = (fanficRating, $ratingElement) ->
		$ratingElement.raty("score", fanficRating)
	setUsersRating = (rating) ->
		$ratingElement = $(this)
		$.ajax({
			url: contextPath + "/setFanficRating/" +
				$ratingElement.attr("fanficId") + "/" + rating,
			type: "post",
			success: (fanficRating) -> setFanficRating(fanficRating, $ratingElement)
		})
	if $("#isLogged").attr("value") == "true"
		$rating.each(->
			rating = $(this).attr("rating")
			$(this).raty($.extend({
				click: setUsersRating,
				score: rating
				}, baseRatyOptions)
			)
		)
	else
		$rating.each(->
			rating = $(this).attr("rating")
			$(this).raty($.extend({
				readOnly: true,
				score: rating
				}, baseRatyOptions)
			)
		)