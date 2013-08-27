
$ ->
	$fontSizes = $("#fontSizes")
	$resizableChapterPlace = $("#resizableChapterPlace")
	fontSize = 10
	while (fontSize <= 32)
		fontSize += 2
		$option = $("<option></option>")
		if fontSize == parseInt($resizableChapterPlace.css("font-size"))
			$option.attr("selected", "selected")
		$option.text(fontSize)
		$fontSizes.append($option)
	$fontSizes.change(->
		$resizableChapterPlace.css("font-size", parseInt($(this).val()))
		$resizableChapterPlace.css("line-height", 1)
	)
	$widthRange = $("#widthRange")
	setWidtByWidthRange = ->
		maxWidth = parseFloat($resizableChapterPlace.css("max-width"))
		minWidth = parseFloat($resizableChapterPlace.css("min-width"))
		$resizableChapterPlace.css("width",
			minWidth + ($widthRange.val() * (maxWidth - minWidth)) / 100)
	setWidtByWidthRange()
	$widthRange.bind("change", setWidtByWidthRange)