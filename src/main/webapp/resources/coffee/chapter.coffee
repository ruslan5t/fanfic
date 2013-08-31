
$ ->
	userFontSize = parseInt($.cookie("userFontSize"))
	$resizableChapterPlace = $("#resizableChapterPlace")
	$widthRange = $("#widthRange")
	setFontSize = (fontSize) ->
		$resizableChapterPlace.css("font-size", fontSize)
		$resizableChapterPlace.css("line-height", 1)
		$.cookie("userFontSize", fontSize, { expires: 1 })
	setChapterWidth = (chapterWidth) ->
		maxWidth = parseFloat($resizableChapterPlace.css("max-width"))
		minWidth = parseFloat($resizableChapterPlace.css("min-width"))
		$resizableChapterPlace.css("width", 
			minWidth + (chapterWidth * (maxWidth - minWidth)) / 100)
		$widthRange.val(chapterWidth)
		$.cookie("userChapterWidth", chapterWidth, { expires: 1 })
	if userFontSize == null
		userFontSize = parseInt($resizableChapterPlace.css("font-size"))
	setFontSize(userFontSize)
	if $.cookie("userChapterWidth") == null
		userChapterWidth = 100
	else
		userChapterWidth = parseInt($.cookie("userChapterWidth"))
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