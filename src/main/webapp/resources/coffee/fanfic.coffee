
$ ->
	setHrefToConvertedFile = (hrefToConvertedFile) ->
		$iframe = $("<iframe></iframe>")
		$iframe.attr("src", hrefToConvertedFile)
		$iframe.css("display", "none")
		$("body").append($iframe)
	convertFanficToPdf = ->
		$.ajax({
			url: $("#contextPath").attr("value") + "/convertFanficToPdf/" +
				$("#fanficId").attr("value"),
			type: "post",
			success: setHrefToConvertedFile
		})
	$("#convertToPdf").on("click", convertFanficToPdf)