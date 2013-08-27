
$(function() {
	var $fontSizes = $("#fontSizes");
	var $resizableChapterPlace = $("#resizableChapterPlace");
	var currentFontSize = parseInt($resizableChapterPlace.css("font-size"));
	for (var fontSize = 10; fontSize <= 32; fontSize += 2) {
		var $option = $("<option></option>");
		if (fontSize === currentFontSize) {
			$option.attr("selected", "selected");
		}
		$option.text(fontSize);
		$fontSizes.append($option);
	}
	$fontSizes.change(function() {
		$resizableChapterPlace.css("font-size", parseInt($(this).val()));
		$resizableChapterPlace.css("line-height", 1);
	});
	
	var $widthRange = $("#widthRange");
	setWidtByWidthRange();
	$widthRange.bind("change", setWidtByWidthRange);
	
	function setWidtByWidthRange() {
		var maxWidth = parseFloat($resizableChapterPlace.css("max-width"));
		var minWidth = parseFloat($resizableChapterPlace.css("min-width"));
		
		$resizableChapterPlace.css("width",
				minWidth + ($widthRange.val() * (maxWidth - minWidth)) / 100);
	}
});