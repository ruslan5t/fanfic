
$(function() {
	var $fontSizes = $("#fontSizes");
	var $resizableChapterPlace = $("#resizableChapterPlace");
	$resizableChapterPlace.resizable({
		handles: "e"
	});
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
});