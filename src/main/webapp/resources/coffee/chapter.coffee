
$ ->
	userFontSize = parseInt($.cookie("userFontSize"))
	userChapterWidth = parseInt($.cookie("userChapterWidth"))
	$resizableChapterPlace = $("#resizableChapterPlace")
	$widthRange = $("#widthRange")
	setFontSize = (fontSize) ->
		$resizableChapterPlace.css("font-size", fontSize)
		$resizableChapterPlace.css("line-height", 1)
		$.cookie("userFontSize", fontSize)
	setChapterWidth = (chapterWidth) ->
		maxWidth = parseFloat($resizableChapterPlace.css("max-width"))
		minWidth = parseFloat($resizableChapterPlace.css("min-width"))
		$resizableChapterPlace.css("width", 
			minWidth + (chapterWidth * (maxWidth - minWidth)) / 100)
		$widthRange.val(chapterWidth)
		$.cookie("userChapterWidth", chapterWidth)
	if userFontSize == null
		userFontSize = parseInt($resizableChapterPlace.css("font-size"))
	setFontSize(userFontSize)
	if userChapterWidth == null
		userChapterWidth = parseFloat($resizableChapterPlace.css("width"))
	setChapterWidth(userChapterWidth)
	$fontSizes = $("#fontSizes")
	fontSize = 10
	while (fontSize <= 32)
		fontSize += 2
		$option = $("<option></option>")
		if fontSize == userFontSize
			$option.attr("selected", "selected")
		$option.text(fontSize)
		$fontSizes.append($option)
	$fontSizes.change(-> 
		setFontSize(parseInt($(this).val()))
	)
	setWidtByWidthRange = ->
		setChapterWidth($widthRange.val())
	$widthRange.bind("change", setWidtByWidthRange)